package anys34.com.flirting.domain.user.presentation;

import anys34.com.flirting.domain.user.domain.User;
import anys34.com.flirting.domain.user.exception.*;
import anys34.com.flirting.domain.user.facade.UserFacade;
import anys34.com.flirting.domain.user.service.UserService;
import anys34.com.flirting.domain.user.service.sha256;
import anys34.com.flirting.domain.user.presentation.dto.req.LoginDto;
import anys34.com.flirting.domain.user.presentation.dto.req.SignInDto;
import anys34.com.flirting.domain.user.presentation.dto.res.UserInfoDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final UserFacade userFacade;
    private final sha256 sha256;

    @GetMapping("/profile/{id}")
    public UserInfoDto profile(@PathVariable Long id) {
        return new UserInfoDto(userFacade.getUserById(id));
    }

    // 회원 가입
    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody SignInDto signInDto) throws NoSuchAlgorithmException {
        if(signInDto.getUserId().isEmpty()) throw BlankIdException.EXCEPTION;
        if(signInDto.getName().isEmpty()) throw BlankNameException.EXCEPTION;
        if(signInDto.getPassword().isEmpty()) throw BlankPasswordException.EXCEPTION;
        if(signInDto.getUserId().length() > 25) throw OverFlowIdException.EXCEPTION;
        if(signInDto.getName().length() > 10) throw OverFlowNameException.EXCEPTION;
        if(userService.checkUserId(signInDto.getUserId())) throw SameIdException.EXCEPTION;

        try {
            // 비밀번호 암호화
            signInDto.setPassword(sha256.encrypt(signInDto.getPassword()));

            // 회원 생성
            userService.signIn(signInDto);
            return ResponseEntity.ok("회원가입 성공");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    // 로그인
    @PostMapping("/login")
    public Long login(@RequestBody LoginDto loginDto) {
        if (loginDto.getUserId().isEmpty()) throw BlankIdException.EXCEPTION;
        if (loginDto.getPassword().isEmpty()) throw BlankPasswordException.EXCEPTION;

        try {
            loginDto.setPassword(sha256.encrypt(loginDto.getPassword()));
        } catch (NoSuchAlgorithmException e) {}

        return userService.login(loginDto);
    }

    // 로그아웃
    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        // 세션 조회
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 세션 삭제
            session.invalidate();
            return ResponseEntity.ok("로그아웃 성공");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

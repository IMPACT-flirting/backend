package anys34.com.flirting.domain.user.service;

import anys34.com.flirting.domain.user.domain.User;
import anys34.com.flirting.domain.user.domain.repository.UserRepository;
import anys34.com.flirting.domain.user.exception.UserNotFoundException;
import anys34.com.flirting.domain.user.presentation.dto.req.LoginDto;
import anys34.com.flirting.domain.user.presentation.dto.req.SignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long signIn(SignInDto signInDto) {
        return userRepository.save(signInDto.toEntity()).getId();
    }

    @Transactional
    public Long login(LoginDto loginDto) {
        return userRepository.findByUserIdAndPassword(loginDto.getUserId(), loginDto.getPassword())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION).getId();
    }

    @Transactional
    public Boolean checkUserId(String userId) {
        return userRepository.findByUserId(userId) != null;
    }
}

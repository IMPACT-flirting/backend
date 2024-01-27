package anys34.com.flirting.service;

import anys34.com.flirting.domain.user.User;
import anys34.com.flirting.domain.user.UserRepository;
import anys34.com.flirting.web.dto.LoginDto;
import anys34.com.flirting.web.dto.SignInDto;
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
    public Pair<User, Boolean> login(LoginDto loginDto) {
        String userId = loginDto.getUserId();
        String password = loginDto.getPassword();
        User user = userRepository.findByUserIdAndPassword(userId, password);

        if (user != null) return Pair.of(user, true);
        if (user == null) return Pair.of(user, false);
        throw new IllegalArgumentException();
    }

    @Transactional
    public User select(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저가 없습니다."));
    }

    @Transactional
    public Boolean checkUserId(String userId) {
        return userRepository.findByUserId(userId) != null;
    }
}

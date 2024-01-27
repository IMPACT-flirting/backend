package anys34.com.flirting.domain.user.facade;

import anys34.com.flirting.domain.user.domain.User;
import anys34.com.flirting.domain.user.domain.repository.UserRepository;
import anys34.com.flirting.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserFacade {
    private final UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}

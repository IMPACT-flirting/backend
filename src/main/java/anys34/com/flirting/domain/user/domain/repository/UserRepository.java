package anys34.com.flirting.domain.user.domain.repository;

import anys34.com.flirting.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 주어진 userId와 password에 대응하는 사용자를 조회하는 데 사용됩니다.
    Optional<User> findByUserIdAndPassword(String userId, String password);

//    주어진 userId에 대응하는 사용자를 조회하는 데 사용됩니다.
    User findByUserId(String userId);
}

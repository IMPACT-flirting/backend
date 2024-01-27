package anys34.com.flirting.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User { // user 테이블 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }
}

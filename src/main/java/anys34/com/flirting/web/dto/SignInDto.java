package anys34.com.flirting.web.dto;

import anys34.com.flirting.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInDto {
    private String userId;
    private String name;
    private String password;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .name(name)
                .password(password)
                .build();
    }
}

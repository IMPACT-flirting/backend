package anys34.com.flirting.domain.user.presentation.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginDto {
    private String userId;
    private String password;
}

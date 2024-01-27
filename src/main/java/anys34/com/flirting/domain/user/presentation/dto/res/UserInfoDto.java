package anys34.com.flirting.domain.user.presentation.dto.res;

import anys34.com.flirting.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class UserInfoDto implements Serializable {
    private Long id;
    private String userId;
    private String name;

    public UserInfoDto(User user) {
        this.id = user .getId();
        this.userId = user.getUserId();
        this.name = user.getName();
    }
}

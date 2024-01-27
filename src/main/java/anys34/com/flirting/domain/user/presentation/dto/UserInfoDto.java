package anys34.com.flirting.domain.user.presentation.dto;

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

    @Builder
    public UserInfoDto(Long id, String userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }
}

package anys34.com.flirting.domain.place.presentation.dto.req;

import anys34.com.flirting.domain.hashTag.domain.Hashtag;
import anys34.com.flirting.domain.place.domain.Place;
import anys34.com.flirting.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class SavePlaceRequest {
    private Long userId;
    private String title;
    private String contents;
    private String address;
    private List<String> hashtags;

    public Place toEntity(List<Hashtag> hashtags, User user) {
        return Place.builder()
                .user(user)
                .title(title)
                .contents(contents)
                .address(address)
                .hashtags(hashtags)
                .build();
    }
}

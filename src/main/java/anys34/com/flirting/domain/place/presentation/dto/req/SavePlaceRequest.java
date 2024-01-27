package anys34.com.flirting.domain.place.presentation.dto.req;

import anys34.com.flirting.domain.hashTag.domain.Hashtag;
import anys34.com.flirting.domain.place.domain.Place;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class SavePlaceRequest {
    private String title;
    private String contents;
    private String address;
    private List<String> hashtags;

    public Place toEntity(List<Hashtag> hashtags) {
        return Place.builder()
                .title(title)
                .contents(contents)
                .address(address)
                .hashtags(hashtags)
                .build();
    }
}

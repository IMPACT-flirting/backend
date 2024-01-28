package anys34.com.flirting.domain.place.presentation.dto.res;

import anys34.com.flirting.domain.hashTag.domain.Hashtag;
import anys34.com.flirting.domain.place.domain.Place;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PlaceInfoResponse {
    private String title;
    private String contents;
    private String address;
    private String img;
    private List<String> hashtags;

    public PlaceInfoResponse(Place place) {
        title = place.getTitle();
        contents = place.getContents();
        address = place.getAddress();
        img = place.getImgUrl();
        hashtags = place.getHashtags().stream().map(Hashtag::getName).collect(Collectors.toList());
    }
}

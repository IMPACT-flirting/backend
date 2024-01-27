package anys34.com.flirting.domain.place.presentation.dto.res;

import anys34.com.flirting.domain.place.domain.Place;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListPlaceResponse {
    private Long id;
    private String title;
    private String contents;
    private String img;

    public ListPlaceResponse(Place place) {
        this.id = place.getId();
        this.title = place.getTitle();
        this.contents = place.getContents();
        this.img = place.getImgUrl();
    }
}

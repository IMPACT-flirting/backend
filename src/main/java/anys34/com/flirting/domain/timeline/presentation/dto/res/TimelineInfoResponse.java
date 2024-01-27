package anys34.com.flirting.domain.timeline.presentation.dto.res;

import anys34.com.flirting.domain.hashTag.domain.Hashtag;
import anys34.com.flirting.domain.place.domain.Place;
import anys34.com.flirting.domain.timeline.domain.Timeline;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class TimelineInfoResponse {
    private String title;
    private String date;
    private List<String> hashtags;
    private List<Long> places;


    public TimelineInfoResponse(Timeline timeline) {
        title = timeline.getTitle();
        date = timeline.getDate();
        hashtags = timeline.getHashtags().stream().map(Hashtag::getName).collect(Collectors.toList());
        places = timeline.getPlacetags().stream().map(Place::getId).collect(Collectors.toList());
    }
}


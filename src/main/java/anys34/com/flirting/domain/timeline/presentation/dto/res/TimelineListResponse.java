package anys34.com.flirting.domain.timeline.presentation.dto.res;

import anys34.com.flirting.domain.timeline.domain.Timeline;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TimelineListResponse {
    private Long postId;
    private String date;

    public TimelineListResponse(Timeline timeline) {
        postId = timeline.getId();
        date = timeline.getDate();
    }
}

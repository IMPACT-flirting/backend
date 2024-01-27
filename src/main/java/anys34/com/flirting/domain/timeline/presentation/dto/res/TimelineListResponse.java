package anys34.com.flirting.domain.timeline.presentation.dto.res;

import anys34.com.flirting.domain.timeline.domain.Timeline;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TimelineListResponse {
    private String date;

    public TimelineListResponse(Timeline timeline) {
        date = timeline.getDate();
    }
}

package anys34.com.flirting.domain.timeline.presentation.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SaveSpotRequest {
    private List<Long> spotId;
    private Long timelineId;

}

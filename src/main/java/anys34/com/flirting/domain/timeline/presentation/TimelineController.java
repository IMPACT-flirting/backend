package anys34.com.flirting.domain.timeline.presentation;

import anys34.com.flirting.domain.timeline.presentation.dto.req.SaveTimelineRequest;
import anys34.com.flirting.domain.timeline.service.SaveTimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TimelineController {
    private final SaveTimelineService saveTimelineService;

    @PostMapping("/timeline/save")
    public void save(@RequestBody SaveTimelineRequest saveTimelineRequest) {
        saveTimelineService.execute(saveTimelineRequest);
    }
}

package anys34.com.flirting.domain.timeline.presentation;

import anys34.com.flirting.domain.timeline.presentation.dto.req.SaveSpotRequest;
import anys34.com.flirting.domain.timeline.presentation.dto.req.SaveTimelineRequest;
import anys34.com.flirting.domain.timeline.presentation.dto.res.TimelineListResponse;
import anys34.com.flirting.domain.timeline.service.SaveSpotService;
import anys34.com.flirting.domain.timeline.service.SaveTimelineService;
import anys34.com.flirting.domain.timeline.service.TimelineListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/timeline")
@RestController
public class TimelineController {
    private final SaveTimelineService saveTimelineService;
    private final TimelineListService timelineListService;
    private final SaveSpotService saveSpotService;

    @PostMapping("/save")
    public void save(@RequestBody SaveTimelineRequest saveTimelineRequest) {
        saveTimelineService.execute(saveTimelineRequest);
    }

    @GetMapping("/list/{id}")
    public List<TimelineListResponse>list(@PathVariable Long id) {
        return timelineListService.execute(id);
    }

    @PostMapping("/spot")
    public void spot(@RequestBody SaveSpotRequest saveSpotRequest) {
        saveSpotService.execute(saveSpotRequest);
    }
}

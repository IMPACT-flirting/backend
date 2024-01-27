package anys34.com.flirting.domain.timeline.service;

import anys34.com.flirting.domain.timeline.domain.Timeline;
import anys34.com.flirting.domain.timeline.domain.repository.TimelineRepository;
import anys34.com.flirting.domain.timeline.presentation.dto.res.TimelineInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TimelineInfoService {
    private final TimelineRepository timelineRepository;

    @Transactional(readOnly = true)
    public TimelineInfoResponse execute(Long id) {
        Timeline timeline = timelineRepository.findById(id).orElseThrow(()-> new RuntimeException("타임라인을 찾을 수 없음"));
        return new TimelineInfoResponse(timeline);
    }
}

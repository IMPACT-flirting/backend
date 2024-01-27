package anys34.com.flirting.domain.timeline.service;

import anys34.com.flirting.domain.timeline.domain.repository.TimelineRepository;
import anys34.com.flirting.domain.timeline.presentation.dto.res.TimelineListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TimelineListService {
    private final TimelineRepository timelineRepository;

    public List<TimelineListResponse> execute(Long id) {
        return timelineRepository.findById(id).stream()
                .map(TimelineListResponse::new)
                .collect(Collectors.toList());
    }
}

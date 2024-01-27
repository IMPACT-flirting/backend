package anys34.com.flirting.domain.timeline.service;

import anys34.com.flirting.domain.place.domain.Place;
import anys34.com.flirting.domain.place.domain.repository.PlaceRepository;
import anys34.com.flirting.domain.place.exception.PlaceNotFoundException;
import anys34.com.flirting.domain.timeline.domain.Timeline;
import anys34.com.flirting.domain.timeline.domain.repository.TimelineRepository;
import anys34.com.flirting.domain.timeline.presentation.dto.req.SaveSpotRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SaveSpotService {
    private final PlaceRepository placeRepository;
    private final TimelineRepository timelineRepository;

    @Transactional
    public void execute(SaveSpotRequest saveSpotRequest) {
        List<Place> places = new ArrayList<>();
        for(Long spotId : saveSpotRequest.getSpotId()) {
            Place place = placeRepository.findById(spotId)
                    .orElseThrow(() -> PlaceNotFoundException.EXCEPTION);
            places.add(place);
        }
        Timeline timeline = timelineRepository.findById(saveSpotRequest.getTimelineId())
                .orElseThrow(() -> new RuntimeException("타임라인을 찾지 못함"));
        timeline.updatePlaces(places);
    }
}

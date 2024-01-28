package anys34.com.flirting.domain.place.service;

import anys34.com.flirting.domain.place.domain.Place;
import anys34.com.flirting.domain.place.domain.repository.PlaceRepository;
import anys34.com.flirting.domain.place.exception.PlaceNotFoundException;
import anys34.com.flirting.domain.place.presentation.dto.res.PlaceInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PlaceInfoService {
    private final PlaceRepository placeRepository;

    @Transactional(readOnly = true)
    public PlaceInfoResponse execute(Long id) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> PlaceNotFoundException.EXCEPTION);
        return new PlaceInfoResponse(place);
    }
}

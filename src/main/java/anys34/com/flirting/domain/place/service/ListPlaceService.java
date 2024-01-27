package anys34.com.flirting.domain.place.service;

import anys34.com.flirting.domain.place.domain.Place;
import anys34.com.flirting.domain.place.domain.repository.PlaceRepository;
import anys34.com.flirting.domain.place.presentation.dto.res.ListPlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ListPlaceService {
    private final PlaceRepository placeRepository;

    public List<ListPlaceResponse> execute() {
        return placeRepository.findAll().stream()
                .map(ListPlaceResponse::new)
                .collect(Collectors.toList());
    }
}

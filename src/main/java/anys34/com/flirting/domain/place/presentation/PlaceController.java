package anys34.com.flirting.domain.place.presentation;

import anys34.com.flirting.domain.place.presentation.dto.req.SavePlaceRequest;
import anys34.com.flirting.domain.place.service.SavePlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PlaceController {
    private final SavePlaceService savePlaceService;

    @PostMapping("/save")
    public void save(@RequestBody SavePlaceRequest savePlaceRequest) {
        savePlaceService.execute(savePlaceRequest);
    }
}

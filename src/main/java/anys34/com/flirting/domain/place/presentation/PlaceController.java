package anys34.com.flirting.domain.place.presentation;

import anys34.com.flirting.domain.place.presentation.dto.req.SaveCommentRequest;
import anys34.com.flirting.domain.place.presentation.dto.req.SavePlaceRequest;
import anys34.com.flirting.domain.place.presentation.dto.res.ListPlaceResponse;
import anys34.com.flirting.domain.place.service.ListPlaceService;
import anys34.com.flirting.domain.place.service.SaveCommentService;
import anys34.com.flirting.domain.place.service.SavePlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PlaceController {
    private final SavePlaceService savePlaceService;
    private final ListPlaceService listPlaceService;
    private final SaveCommentService saveCommentService;

    @GetMapping("/list")
    public List<ListPlaceResponse> list() {
        return listPlaceService.execute();
    }

    @PostMapping("/save")
    public Long save(@RequestBody SavePlaceRequest savePlaceRequest) {
        return savePlaceService.execute(savePlaceRequest);
    }

    @PostMapping("/comment")
    public void comment(@RequestBody SaveCommentRequest saveCommentRequest) {
        saveCommentService.execute(saveCommentRequest);
    }
}

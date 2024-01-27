package anys34.com.flirting.domain.place.presentation;

import anys34.com.flirting.domain.comment.domain.Comment;
import anys34.com.flirting.domain.place.presentation.dto.req.SaveCommentRequest;
import anys34.com.flirting.domain.place.presentation.dto.req.SavePlaceRequest;
import anys34.com.flirting.domain.place.presentation.dto.res.ListCommentResponse;
import anys34.com.flirting.domain.place.presentation.dto.res.ListPlaceResponse;
import anys34.com.flirting.domain.place.service.ListCommentService;
import anys34.com.flirting.domain.place.service.ListPlaceService;
import anys34.com.flirting.domain.place.service.SaveCommentService;
import anys34.com.flirting.domain.place.service.SavePlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PlaceController {
    private final SavePlaceService savePlaceService;
    private final ListPlaceService listPlaceService;
    private final SaveCommentService saveCommentService;
    private final ListCommentService listCommentService;

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

    @GetMapping("/comment/{id}")
    public List<ListCommentResponse> commentList(@PathVariable Long id) {
        return listCommentService.execute(id);
    }
}

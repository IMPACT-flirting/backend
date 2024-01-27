package anys34.com.flirting.domain.place.presentation;

import anys34.com.flirting.domain.comment.domain.Comment;
import anys34.com.flirting.domain.place.presentation.dto.req.SaveCommentRequest;
import anys34.com.flirting.domain.place.presentation.dto.req.SavePlaceRequest;
import anys34.com.flirting.domain.place.presentation.dto.res.ListCommentResponse;
import anys34.com.flirting.domain.place.presentation.dto.res.ListPlaceResponse;
import anys34.com.flirting.domain.place.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PlaceController {
    private final SavePlaceService savePlaceService;
    private final ListPlaceService listPlaceService;
    private final SaveCommentService saveCommentService;
    private final ListCommentService listCommentService;
    private final UploadPictureService uploadPictureService;

    @GetMapping("/list")
    public List<ListPlaceResponse> list() {
        return listPlaceService.execute();
    }

    @PostMapping("/save")
    public Long save(@RequestBody SavePlaceRequest savePlaceRequest) {
        return savePlaceService.execute(savePlaceRequest);
    }

    @PostMapping("/picture")
    public void uploadImg(@RequestParam("id") Long id,
                            @RequestParam("file") MultipartFile file) {
        uploadPictureService.execute(id, file);
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

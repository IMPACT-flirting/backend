package anys34.com.flirting.domain.place.service;

import anys34.com.flirting.domain.comment.domain.repository.CommentRepository;
import anys34.com.flirting.domain.place.domain.Place;
import anys34.com.flirting.domain.place.domain.repository.PlaceRepository;
import anys34.com.flirting.domain.place.exception.PlaceNotFoundException;
import anys34.com.flirting.domain.place.presentation.dto.req.SaveCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SaveCommentService {
    private final PlaceRepository placeRepository;

    @Transactional
    public void execute(SaveCommentRequest saveCommentRequest) {
        Place place = placeRepository.findById(saveCommentRequest.getPostId())
                .orElseThrow(() -> PlaceNotFoundException.EXCEPTION);

        place.getComments().add(saveCommentRequest.toEntity(place));

        placeRepository.save(place);
    }
}

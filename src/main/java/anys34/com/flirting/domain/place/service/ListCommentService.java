package anys34.com.flirting.domain.place.service;

import anys34.com.flirting.domain.comment.domain.Comment;
import anys34.com.flirting.domain.place.domain.repository.PlaceRepository;
import anys34.com.flirting.domain.place.exception.PlaceNotFoundException;
import anys34.com.flirting.domain.place.presentation.dto.res.ListCommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ListCommentService {
    private final PlaceRepository placeRepository;

    @Transactional(readOnly = true)
    public List<ListCommentResponse> execute(Long id) {
        return placeRepository.findById(id)
                .orElseThrow(() -> PlaceNotFoundException.EXCEPTION).getComments().stream()
                .map(ListCommentResponse::new)
                .collect(Collectors.toList());
    }
}

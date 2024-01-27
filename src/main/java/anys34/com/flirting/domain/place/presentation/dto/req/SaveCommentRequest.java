package anys34.com.flirting.domain.place.presentation.dto.req;

import anys34.com.flirting.domain.comment.domain.Comment;
import anys34.com.flirting.domain.place.domain.Place;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveCommentRequest {
    private Long postId;
    private String comment;

    public Comment toEntity(Place place) {
        return Comment.builder()
                .text(comment)
                .place(place)
                .build();
    }
}

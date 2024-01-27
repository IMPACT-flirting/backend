package anys34.com.flirting.domain.place.presentation.dto.res;

import anys34.com.flirting.domain.comment.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListCommentResponse {
    private String text;

    public ListCommentResponse(Comment comment) {
        text = comment.getText();
    }
}

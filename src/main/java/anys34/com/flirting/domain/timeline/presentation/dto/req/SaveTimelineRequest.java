package anys34.com.flirting.domain.timeline.presentation.dto.req;

import anys34.com.flirting.domain.hashTag.domain.Hashtag;
import anys34.com.flirting.domain.timeline.domain.Timeline;
import anys34.com.flirting.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class SaveTimelineRequest {
    private Long userId;
    private String title;
    private String date;
    private List<String> hashtag;

    public Timeline toEntity(List<Hashtag> hashtags, User user) {
        return Timeline.builder()
                .title(title)
                .date(date)
                .hashtags(hashtags)
                .user(user)
                .build();
    }
}

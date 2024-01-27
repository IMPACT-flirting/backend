package anys34.com.flirting.domain.timeline.service;

import anys34.com.flirting.domain.hashTag.domain.Hashtag;
import anys34.com.flirting.domain.hashTag.domain.repository.HashtagRepository;
import anys34.com.flirting.domain.timeline.domain.repository.TimelineRepository;
import anys34.com.flirting.domain.timeline.presentation.dto.req.SaveTimelineRequest;
import anys34.com.flirting.domain.user.domain.User;
import anys34.com.flirting.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SaveTimelineService {
    private final TimelineRepository timelineRepository;
    private final HashtagRepository hashtagRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(SaveTimelineRequest saveTimelineRequest) {
        User user = userFacade.getUserById(saveTimelineRequest.getUserId());

        List<Hashtag> hashtags = new ArrayList<>();
        for (String hashtagName : saveTimelineRequest.getHashtag()) {
            Hashtag existingHashtag = hashtagRepository.findByName(hashtagName);
            if (existingHashtag == null) {
                Hashtag newHashtag = new Hashtag();
                newHashtag.setName(hashtagName);
                existingHashtag = hashtagRepository.save(newHashtag);
            }
            hashtags.add(existingHashtag);
        }

        timelineRepository.save(saveTimelineRequest.toEntity(hashtags, user));
    }
}

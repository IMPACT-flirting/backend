package anys34.com.flirting.domain.place.service;


import anys34.com.flirting.domain.hashTag.domain.Hashtag;
import anys34.com.flirting.domain.hashTag.domain.repository.HashtagRepository;
import anys34.com.flirting.domain.place.domain.repository.PlaceRepository;
import anys34.com.flirting.domain.place.presentation.dto.req.SavePlaceRequest;
import anys34.com.flirting.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SavePlaceService {
    private final PlaceRepository placeRepository;
    private final HashtagRepository hashtagRepository;
    private final UserFacade userFacade;

    @Transactional
    public Long execute(SavePlaceRequest savePlaceRequest) {
        List<Hashtag> hashtags = new ArrayList<>();
        for (String hashtagName : savePlaceRequest.getHashtags()) {
            Hashtag existingHashtag = hashtagRepository.findByName(hashtagName);
            if (existingHashtag == null) {
                Hashtag newHashtag = new Hashtag();
                newHashtag.setName(hashtagName);
                existingHashtag = hashtagRepository.save(newHashtag);
            }
            hashtags.add(existingHashtag);
        }

        return placeRepository.save(savePlaceRequest.toEntity(hashtags, userFacade.getUserById(savePlaceRequest.getId()))).getId();
    }
}

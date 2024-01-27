package anys34.com.flirting.domain.place.service;

import anys34.com.flirting.domain.place.domain.Place;
import anys34.com.flirting.domain.place.domain.repository.PlaceRepository;
import anys34.com.flirting.domain.place.exception.PlaceNotFoundException;
import anys34.com.flirting.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UploadPictureService {
    private final PlaceRepository placeRepository;
    private final S3Service s3Service;

    public void execute(Long id, MultipartFile file) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> PlaceNotFoundException.EXCEPTION);
        String imgUrl = s3Service.uploadFile(file);
        place.uploadImg(imgUrl);
    }
}

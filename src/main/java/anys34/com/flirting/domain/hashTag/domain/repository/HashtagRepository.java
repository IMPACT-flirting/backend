package anys34.com.flirting.domain.hashTag.domain.repository;

import anys34.com.flirting.domain.hashTag.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    Hashtag findByName(String name);
}

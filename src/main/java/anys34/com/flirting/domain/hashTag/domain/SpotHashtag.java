package anys34.com.flirting.domain.hashTag.domain;

import anys34.com.flirting.domain.place.domain.Place;
import anys34.com.flirting.domain.timeline.domain.Timeline;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "spot_hashtag")
public class SpotHashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "timeline_id")
    private Timeline timeline;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
}

package anys34.com.flirting.domain.hashTag.domain;

import anys34.com.flirting.domain.place.domain.Place;
import jakarta.persistence.*;

@Entity
@Table(name = "place_hashtag")
public class PlaceHashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;
}

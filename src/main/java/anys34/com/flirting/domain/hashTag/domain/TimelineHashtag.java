package anys34.com.flirting.domain.hashTag.domain;

import anys34.com.flirting.domain.timeline.domain.Timeline;
import jakarta.persistence.*;

@Entity
@Table(name = "timeline_hashtag")
public class TimelineHashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "timeline_id")
    private Timeline timeline;

    @ManyToOne
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;
}

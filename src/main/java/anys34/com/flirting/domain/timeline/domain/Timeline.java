package anys34.com.flirting.domain.timeline.domain;

import anys34.com.flirting.domain.hashTag.domain.Hashtag;
import anys34.com.flirting.domain.place.domain.Place;
import anys34.com.flirting.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Timeline {
    @Id
    @Column(name = "timeline_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "timeline_hashtag",
            joinColumns = @JoinColumn(name = "timeline_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private List<Hashtag> hashtags;

    @ManyToMany
    @JoinTable(
            name = "spot_hashtag",
            joinColumns = @JoinColumn(name = "timeline_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private List<Place> placetags;

    @Builder
    public Timeline(String title, String date, List<Hashtag> hashtags, User user) {
        this.title = title;
        this.date = date;
        this.hashtags = hashtags;
        this.user = user;
    }
}

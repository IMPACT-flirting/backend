package anys34.com.flirting.domain.comment.domain;

import anys34.com.flirting.domain.place.domain.Place;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @Builder
    public Comment(String text, Place place) {
        this.text = text;
        this.place = place;
    }
}
package anys34.com.flirting.domain.place.domain;

import anys34.com.flirting.domain.comment.domain.Comment;
import anys34.com.flirting.domain.hashTag.domain.Hashtag;
import anys34.com.flirting.domain.user.domain.User;
import anys34.com.flirting.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Place extends BaseTimeEntity {
    @Id
    @Column(name = "place_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String contents;

    @Column(name = "img_url")
    private String imgUrl;

    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "place_hashtag",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private List<Hashtag> hashtags;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Builder
    public Place(User user, String title, String contents, String address,  List<Hashtag> hashtags) {
        this.user = user;
        this.title = title;
        this.contents = contents;
        this.address = address;
        this.hashtags = hashtags;
    }

    public void uploadImg(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

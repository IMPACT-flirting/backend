package anys34.com.flirting.domain.hashTag.domain;

import jakarta.persistence.*;
import lombok.Setter;

@Setter
@Entity
@Table(name = "hashtag")
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}




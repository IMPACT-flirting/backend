package anys34.com.flirting.domain.comment.domain.repository;

import anys34.com.flirting.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

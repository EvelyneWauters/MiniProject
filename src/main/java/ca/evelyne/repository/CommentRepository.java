package ca.evelyne.repository;

import ca.evelyne.domain.person.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Evelyne on 13/07/15.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

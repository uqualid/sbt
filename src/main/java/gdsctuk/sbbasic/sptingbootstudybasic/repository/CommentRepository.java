package gdsctuk.sbbasic.sptingbootstudybasic.repository;

import gdsctuk.sbbasic.sptingbootstudybasic.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    //@Query("SELECT c FROM Comment c WHERE c.bId = :bId")
    //List<Comment> findAllByBId(Long id); // Long bId

    Comment save(Comment comment);
    Optional<Comment> findById(Long id);
    List<Comment> findAll();
}

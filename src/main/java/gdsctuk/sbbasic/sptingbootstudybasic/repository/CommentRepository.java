package gdsctuk.sbbasic.sptingbootstudybasic.repository;

import gdsctuk.sbbasic.sptingbootstudybasic.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.bId = :bId")
    List<Comment> findAllByBId(Long bId);
}

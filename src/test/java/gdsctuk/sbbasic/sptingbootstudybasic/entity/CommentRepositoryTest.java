package gdsctuk.sbbasic.sptingbootstudybasic.entity;

import gdsctuk.sbbasic.sptingbootstudybasic.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    @Transactional
    void saveComment() {
        // Given
        Comment comment = Comment.builder()
                .bId(1L)
                .commentWriter("Test Writer")
                .commentContent("Test Content")
                .build();

        // When
        Comment savedComment = commentRepository.save(comment);

        // Then
        assertNotNull(savedComment.getCommentId()); // 식별자가 생성되었는지 확인
        assertEquals(1L, savedComment.getBId());
        assertEquals("Test Writer", savedComment.getCommentWriter());
        assertEquals("Test Content", savedComment.getCommentContent());
        assertNotNull(savedComment.getCommentWriteTime());
        assertNotNull(savedComment.getCommentEditTime());
    }

    @Test
    @Transactional
    void findCommentsByBId() {
        // Given
        Comment comment1 = Comment.builder().bId(1L).commentWriter("Writer 1").commentContent("Content 1").build();
        Comment comment2 = Comment.builder().bId(1L).commentWriter("Writer 2").commentContent("Content 2").build();

        commentRepository.save(comment1);
        commentRepository.save(comment2);

        // When
        List<Comment> comments = commentRepository.findAllByBId(1L);

        // Then
        assertEquals(2, comments.size());
    }
}
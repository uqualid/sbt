package gdsctuk.sbbasic.sptingbootstudybasic.entity;

import gdsctuk.sbbasic.sptingbootstudybasic.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @Transactional
    void saveBoard() {
        // Given
        Board board = Board.builder()
                .boardTitle("Test Title")
                .boardContent("Test Content")
                .boardWriter("Test Writer")
                .build();

        // When
        Board savedBoard = boardRepository.save(board);

        // Then
        assertNotNull(savedBoard.getBoardId()); // 식별자가 생성되었는지 확인
        assertEquals("Test Title", savedBoard.getBoardTitle());
        assertEquals("Test Content", savedBoard.getBoardContent());
        assertEquals("Test Writer", savedBoard.getBoardWriter());
        assertNotNull(savedBoard.getBoardWriteTime());
        assertNotNull(savedBoard.getBoardEditTime());
    }

    @Test
    @Transactional
    void findAllBoards() {
        // Given
        Board board1 = Board.builder().boardTitle("Title 1").boardContent("Content 1").boardWriter("Writer 1").build();
        Board board2 = Board.builder().boardTitle("Title 2").boardContent("Content 2").boardWriter("Writer 2").build();

        boardRepository.save(board1);
        boardRepository.save(board2);

        // When
        List<Board> boards = boardRepository.findAll();

        // Then
        assertEquals(2, boards.size());
    }
}
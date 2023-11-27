package gdsctuk.sbbasic.sptingbootstudybasic.repository;

import gdsctuk.sbbasic.sptingbootstudybasic.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//반환 형태, method 명을 미리 선언 - interface
public interface BoardRepository extends JpaRepository<Board, Long>{

    Board save(Board board);
    Optional<Board> findById(Long id);
    List<Board> findAll(); // method - 반환값 List(Board)
}
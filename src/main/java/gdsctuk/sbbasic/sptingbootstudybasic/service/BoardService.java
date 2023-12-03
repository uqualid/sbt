package gdsctuk.sbbasic.sptingbootstudybasic.service;

import gdsctuk.sbbasic.sptingbootstudybasic.dto.request.BoardRequestDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.request.BoardUpdateDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.BoardResponseDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.BoardResponseIdDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.BoardResponseListDto;
import gdsctuk.sbbasic.sptingbootstudybasic.entity.Board;
import gdsctuk.sbbasic.sptingbootstudybasic.mapper.BoardMapper;
import gdsctuk.sbbasic.sptingbootstudybasic.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardService {
    // request가 보드에 들어갈 수 있는 mapper 짜서 board rep save 하도록

    private final BoardRepository boardRepository; //private final 선언해야 17번 의존성 주입 가능
    private final BoardMapper boardMapper;

    // 게시글 생성
    public BoardResponseIdDto createBoard(BoardRequestDto request) {
        Board board = boardRepository.save(boardMapper.toEntity(request)); // 값 저장
        BoardResponseIdDto boardResponseIdDto = boardMapper.toResponseId(board);  //return boardMapper.toResponseId(board);
        return boardResponseIdDto;
    }


    // 게시글 List 조회
    public BoardResponseListDto findAllBoard() {
        List<Board> boards = boardRepository.findAll(); // List는 s 붙여서 처리 많음

        return boardMapper.toListResponse(boards);
    }

    // 게시글 하나 조회
    public BoardResponseDto findOneBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(IllegalStateException::new);

        return boardMapper.toResponse(board);
    }

    // 게시글 수정
    @Transactional
    public BoardResponseDto updateBoard(BoardUpdateDto request) {
        Board board = boardRepository.findById(request.getBoardId())
                .orElseThrow(IllegalStateException::new);

        board.updateBoard(request.getBoardTitle(), request.getBoardContent());

        return boardMapper.toResponse(board);
    }


    // 게시글 삭제
    @Transactional
    public  BoardResponseDto deleteBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(IllegalStateException::new);
        board.delete();


        return boardMapper.toResponse(board);
    }





}

package gdsctuk.sbbasic.sptingbootstudybasic.mapper;


import gdsctuk.sbbasic.sptingbootstudybasic.dto.BoardRequestDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.BoardResponseDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.BoardResponseIdDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.BoardResponseListDto;
import gdsctuk.sbbasic.sptingbootstudybasic.entity.Board;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BoardMapper {

    public Board toEntity(BoardRequestDto request) { // entity에 알맞게 mapping해주기 위해 선언 - 보드라는 엔티티에 매핑해 주기 위해
        return Board.builder()
                .boardTitle(request.getBoardTitle())
                .boardContent(request.getBoardContent())
                .boardWriter(request.getBoardWriter())      // nullable = false 값들은 모두 포함
                .build();
    }

    public BoardResponseIdDto toResponseId(Board board){
        return BoardResponseIdDto.builder()
                .id(board.getBoardId())
                .build();
    }

    public BoardResponseDto toResponse(Board board) {
        return BoardResponseDto.builder()
                .boardId(board.getBoardId())
                .boardTitle(board.getBoardTitle())
                .boardContent(board.getBoardContent())
                .boardEditTime(board.getBoardEditTime())
                .build();
    }

    public BoardResponseListDto toListResponse(List<Board> boardList) {
        List<BoardResponseDto> boardResponseList =
                boardList.stream().map(this::toResponse).collect(Collectors.toList());
                            // 순차 method/클래스 내의 toResponse 사용

        return BoardResponseListDto.builder()
                .boardList(boardResponseList)
                .build();
    }
}
package gdsctuk.sbbasic.sptingbootstudybasic.dto;


import gdsctuk.sbbasic.sptingbootstudybasic.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardResponseDto {

    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;

    private LocalDateTime boardWriteTime;
    private LocalDateTime boardEditTime;


    public BoardResponseDto(Board board){
        this.boardId = board.getBoardId();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.boardWriter = board.getBoardWriter();
        this.boardWriteTime = board.getBoardWriteTime();
        this.boardEditTime = board.getBoardEditTime();
    }
}



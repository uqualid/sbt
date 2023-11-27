package gdsctuk.sbbasic.sptingbootstudybasic.dto;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardRequestDto {

    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;

    private LocalDateTime boardWriteTime;
    private LocalDateTime boardEditTime;

//    public Board toEntity() {
//        return Board.builder()
//                .boardId(boardId)
//                .boardTitle(boardTitle)
//                .boardContent(boardContent)
//                .boardWriter(boardWriter)
//                .boardWriteTime(boardWriteTime)
//                .boardEditTime(boardEditTime)
//                .build();
//    }

}



package gdsctuk.sbbasic.sptingbootstudybasic.dto.request;


import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardUpdateDto{
    private Long boardId;
    private String boardTitle;
    private String boardContent;

}



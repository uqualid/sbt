package gdsctuk.sbbasic.sptingbootstudybasic.dto.request;


import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardRequestDto {

    private String boardTitle;
    private String boardContent;
    private String boardWriter;

}



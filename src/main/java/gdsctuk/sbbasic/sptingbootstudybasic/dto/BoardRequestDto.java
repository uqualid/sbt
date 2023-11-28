package gdsctuk.sbbasic.sptingbootstudybasic.dto;


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



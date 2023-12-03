package gdsctuk.sbbasic.sptingbootstudybasic.dto.request;


import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentUpdateDto {

    private Long bId;
    private Long commentId;
    private String commentContent;
    private String commentWriter;

}



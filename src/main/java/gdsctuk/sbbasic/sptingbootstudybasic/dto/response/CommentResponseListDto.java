package gdsctuk.sbbasic.sptingbootstudybasic.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentResponseListDto {
    private List<CommentResponseDto> commentList;
    //CommentResponseDto를 list 형태로 반환할 때 쓰이는 dto
}

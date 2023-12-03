package gdsctuk.sbbasic.sptingbootstudybasic.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentResponseIdDto {
    private Long id; // id 값을 반환 (Data to Obj)
}

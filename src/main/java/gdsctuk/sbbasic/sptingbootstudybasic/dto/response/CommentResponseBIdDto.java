package gdsctuk.sbbasic.sptingbootstudybasic.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentResponseBIdDto {
    private Long id; // Board id 값을 반환 (Data to Obj)
}
package gdsctuk.sbbasic.sptingbootstudybasic.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardResponseIdDto {
    private Long id; // id 값을 반환 (Data to Obj)
}

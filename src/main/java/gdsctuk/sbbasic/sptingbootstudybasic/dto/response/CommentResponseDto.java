package gdsctuk.sbbasic.sptingbootstudybasic.dto.response;


import gdsctuk.sbbasic.sptingbootstudybasic.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentResponseDto {

    private Long commentId;
    private Long bId;
    private String commentWriter;
    private String commentContent;

    private LocalDateTime commentWriteTime;
    private LocalDateTime commentEditTime;

    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.bId = comment.getBId();
        this.commentWriter = comment.getCommentWriter();
        this.commentContent = comment.getCommentContent();
        this.commentWriteTime = comment.getCommentWriteTime();
        this.commentEditTime = comment.getCommentEditTime();
    }
}



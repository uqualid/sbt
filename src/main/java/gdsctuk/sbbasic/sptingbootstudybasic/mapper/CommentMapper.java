package gdsctuk.sbbasic.sptingbootstudybasic.mapper;


import gdsctuk.sbbasic.sptingbootstudybasic.dto.request.CommentRequestDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.CommentResponseBIdDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.CommentResponseDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.CommentResponseIdDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.CommentResponseListDto;
import gdsctuk.sbbasic.sptingbootstudybasic.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentMapper {

    public Comment toEntity(CommentRequestDto request) { // entity에 알맞게 mapping해주기 위해 선언 - 보드라는 엔티티에 매핑해 주기 위해
        return Comment.builder()
                .bId(request.getBId())
                .commentContent(request.getCommentContent())
                .commentWriter(request.getCommentWriter())      // nullable = false 값들은 모두 포함
                .build();
    }

    public CommentResponseIdDto toResponseId(Comment comment){
        return CommentResponseIdDto.builder()
                .id(comment.getCommentId())
                .build();
    }


    public CommentResponseBIdDto toResponseBId(Comment comment){
        return CommentResponseBIdDto.builder()
                .id(comment.getBId())
                .build();
    }

    public CommentResponseDto toResponse(Comment comment) {
        return CommentResponseDto.builder()
                .commentId(comment.getCommentId())
                .bId(comment.getBId())
                .commentContent(comment.getCommentContent())
                .commentEditTime(comment.getCommentEditTime())
                .build();
    }

    public CommentResponseListDto toListResponse(List<Comment> commentList) {
        List<CommentResponseDto> commentResponseList =
                commentList.stream().map(this::toResponse).collect(Collectors.toList());
                            // 순차 method/클래스 내의 toResponse 사용

        return  CommentResponseListDto.builder()
                .commentList(commentResponseList)
                .build();
    }
}
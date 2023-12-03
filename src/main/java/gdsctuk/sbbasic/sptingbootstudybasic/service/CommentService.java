package gdsctuk.sbbasic.sptingbootstudybasic.service;

import gdsctuk.sbbasic.sptingbootstudybasic.dto.request.CommentRequestDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.request.CommentUpdateDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.CommentResponseDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.CommentResponseIdDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.CommentResponseListDto;
import gdsctuk.sbbasic.sptingbootstudybasic.entity.Comment;
import gdsctuk.sbbasic.sptingbootstudybasic.mapper.CommentMapper;
import gdsctuk.sbbasic.sptingbootstudybasic.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    // 댓글 생성
    public CommentResponseIdDto createComment(CommentRequestDto request) {
        Comment comment = commentRepository.save(commentMapper.toEntity(request)); // 값 저장
        CommentResponseIdDto commentResponseIdDto = commentMapper.toResponseId(comment);  //return commentMapper.toResponseId(board);
        return commentResponseIdDto;
    }


    // 댓글 List 조회
    public CommentResponseListDto findAll(Long id) {
        List<Comment> comments = commentRepository.findAll(); // List는 s 붙여서 처리 많음

        return commentMapper.toListResponse(comments);
    }

    // 댓글 하나 조회
    public CommentResponseDto findOneComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(IllegalStateException::new);

        return commentMapper.toResponse(comment);
    }

    // 댓글 수정
    @Transactional
    public CommentResponseDto updateComment(CommentUpdateDto request) {
        Comment comment = commentRepository.findById(request.getCommentId())
                .orElseThrow(IllegalStateException::new);

        comment.updateComment(request.getCommentContent());

        return commentMapper.toResponse(comment);
    }


    // 댓글 삭제
    @Transactional
    public  CommentResponseDto deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(IllegalStateException::new);
        comment.delete();


        return commentMapper.toResponse(comment);
    }





}

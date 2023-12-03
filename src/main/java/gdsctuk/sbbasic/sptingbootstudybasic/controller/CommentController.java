package gdsctuk.sbbasic.sptingbootstudybasic.controller;

import gdsctuk.sbbasic.sptingbootstudybasic.dto.request.CommentRequestDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.request.CommentUpdateDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.CommentResponseDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.CommentResponseIdDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.response.CommentResponseListDto;
import gdsctuk.sbbasic.sptingbootstudybasic.mapper.CommentMapper;
import gdsctuk.sbbasic.sptingbootstudybasic.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @PostMapping(value = "/create")
    public ResponseEntity<CommentResponseIdDto> createComment(@RequestBody CommentRequestDto request){
        return ResponseEntity.ok(commentService.createComment(request));

    }

    @GetMapping("/list/{id}")
    public ResponseEntity<CommentResponseListDto> findAll(@RequestBody Long id) {
        return ResponseEntity.ok(commentService.findAll(id));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CommentResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.findOneComment(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@RequestBody CommentUpdateDto request) {
        return ResponseEntity.ok(commentService.updateComment(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CommentResponseDto> deleteComment(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.deleteComment(id));
    }

}
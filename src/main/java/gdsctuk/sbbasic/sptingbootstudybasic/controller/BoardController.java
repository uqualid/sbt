package gdsctuk.sbbasic.sptingbootstudybasic.controller;

import gdsctuk.sbbasic.sptingbootstudybasic.dto.BoardRequestDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.BoardResponseDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.BoardResponseIdDto;
import gdsctuk.sbbasic.sptingbootstudybasic.dto.BoardResponseListDto;
import gdsctuk.sbbasic.sptingbootstudybasic.mapper.BoardMapper;
import gdsctuk.sbbasic.sptingbootstudybasic.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper boardMapper;

    @PostMapping("/create")
    public ResponseEntity<BoardResponseIdDto> createBoard(@RequestBody BoardRequestDto request){
        return ResponseEntity.ok(boardService.createBoard(request));

    }

    @GetMapping("/list")
    public ResponseEntity<BoardResponseListDto> findALlBoard() {
        return ResponseEntity.ok(boardService.findAllBoard());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BoardResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.findOneBoard(id));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<BoardResponseDto> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto request) {
        return ResponseEntity.ok(boardService.updateBoard(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BoardResponseDto> deleteBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.deleteBoard(id));
    }


}
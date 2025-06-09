package kr.co.khedu.fitroutine.board.controller;

import kr.co.khedu.fitroutine.board.model.dto.PopularBoard;
import kr.co.khedu.fitroutine.board.service.BoardService;
import kr.co.khedu.fitroutine.board.utils.ImageFileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/boards")
public final class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/popular")
    public List<? extends PopularBoard> getPopularBoardTop3() {
        return boardService.getPopularBoardTop3();
    }

    @PostMapping()
    public ResponseEntity<?> createBoard(
            @RequestHeader("Authorization") String token,
            @RequestPart("title") String title,
            @RequestPart("category") String category,
            @RequestPart("content") String content,
            @RequestPart(value = "images") MultipartFile[] images
    ) {
        // 추후 토큰에서 추출하도록 변경
        int memberId = Integer.parseInt(token);

        long boardId = boardService.saveBoardDetail(title, category, content, memberId);
        if (boardId < 0) {
            return ResponseEntity.status(400).body("failure");
        }

        for (MultipartFile image : images) {
            String changedFileName = ImageFileUtil.saveFile(image);

            boolean result = boardService.saveBoardImage(image.getOriginalFilename(), changedFileName, boardId);
            if (!result) {
                return ResponseEntity.status(400).body("failure");
            }
        }

        return ResponseEntity.status(200).body("success");
    }

}

package kr.co.khedu.fitroutine.board.service;

import kr.co.khedu.fitroutine.board.model.dto.BoardCreate;
import kr.co.khedu.fitroutine.board.mapper.BoardMapper;
import kr.co.khedu.fitroutine.board.model.dto.PopularBoard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<? extends PopularBoard> getPopularBoardTop3() {
        return boardMapper.getPopularBoardTop3();
    }

    public long saveBoardDetail(String title, String category, String content, int memberId) {
        BoardCreate board = BoardCreate.builder()
                .title(title)
                .category(category)
                .content(content)
                .memberId(memberId)
                .build();

        int rows = boardMapper.insertSelectBoard(board); // insert + selectKey로 board.id 세팅됨

        return rows > 0 ? board.getBoardId() : -1L;
    }

    public boolean saveBoardImage(String originalFileName , String changedFileName, long boardId) {
        return boardMapper.saveBoardImage(originalFileName, changedFileName, boardId) > 0;
    }
}

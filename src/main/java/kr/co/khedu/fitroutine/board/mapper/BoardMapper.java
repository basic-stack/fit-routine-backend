package kr.co.khedu.fitroutine.board.mapper;

import kr.co.khedu.fitroutine.board.model.dto.BoardCreate;
import kr.co.khedu.fitroutine.board.model.dto.PopularBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<? extends PopularBoard> getPopularBoardTop3();

    int insertSelectBoard(BoardCreate board);

    int saveBoardImage(String originalFileName, String changedFileName, long boardId);
}

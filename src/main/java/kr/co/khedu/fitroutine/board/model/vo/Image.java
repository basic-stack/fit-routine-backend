package kr.co.khedu.fitroutine.board.model.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class Image {
    private final String originName;
    private final String changeName;
    private final long boardId;

    @Builder
    private Image(String originName, String changeName, long boardId) {
        this.originName = originName;
        this.changeName = changeName;
        this.boardId = boardId;
    }
}

package kr.co.khedu.fitroutine.board.model.dto;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class BoardCreate {
    private final long memberId;
    private final String title;
    private final String category;
    private final String content;
    private @Nullable long boardId;

    @Builder
    public BoardCreate(long memberId, String title, String category, String content) {
        this.memberId = memberId;
        this.title = title;
        this.category = category;
        this.content = content;
    }
}

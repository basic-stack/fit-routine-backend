package kr.co.khedu.fitroutine.post.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public final class ReplyUpdateRequest {
    @NotNull
    private final String content;

    @Builder
    private ReplyUpdateRequest(String content) {
        this.content = content;
    }
}

package kr.co.khedu.fitroutine.blog.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class IntroduceEdit {
    private final String introduce;

    @Builder
    private IntroduceEdit(String introduce) {
        this.introduce = introduce;
    }
}

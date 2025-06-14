package kr.co.khedu.fitroutine.todo.model.dto;

import jakarta.annotation.Nullable;
import lombok.*;

import java.sql.Date;

@Getter
public final class RoutineInfo {

    private final Date startedAt;
    private final Date endedAt;
    private final String purpose;
    private final String category;
    private final int dayRepeat;
    private final @Nullable double tdee;
    private final @Nullable double goalWeight;

    @Builder
    private RoutineInfo(Date startedAt,
                       Date endedAt,
                       String purpose,
                       String category,
                       int dayRepeat,
                       double tdee,
                       double goalWeight) {
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.purpose = purpose;
        this.category = category;
        this.dayRepeat = dayRepeat;
        this.tdee = tdee;
        this.goalWeight = goalWeight;
    }
}

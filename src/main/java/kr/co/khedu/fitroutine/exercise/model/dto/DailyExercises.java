package kr.co.khedu.fitroutine.exercise.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public final class DailyExercises {

    private @Nullable long dailyExerciseId;
    private final long todoId;
    private final int dayNo;

    @Builder
    private DailyExercises(long todoId, int dayNo) {
        this.todoId = todoId;
        this.dayNo = dayNo;
    }
}

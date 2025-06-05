package kr.co.khedu.fitroutine.exercise.model.vo;

import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Getter
public final class ExerciseOpenData {
    private final int exerciseId;
    private final String name;
    private final double met;
    private final String category;


    @Builder
    public ExerciseOpenData(int exerciseId, String name, double met, String category) {
        this.exerciseId = exerciseId;
        this.name = name;
        this.met = met;
        this.category = category;
    }
}

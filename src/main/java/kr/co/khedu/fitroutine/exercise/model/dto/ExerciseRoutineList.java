package kr.co.khedu.fitroutine.exercise.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
public final class ExerciseRoutineList {

    private final List<List<Integer>> exerciseList;

    @Builder
    public ExerciseRoutineList(List<List<Integer>> exerciseList) {
        this.exerciseList = exerciseList;
    }
}

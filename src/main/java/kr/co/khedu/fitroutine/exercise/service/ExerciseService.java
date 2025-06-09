package kr.co.khedu.fitroutine.exercise.service;

import kr.co.khedu.fitroutine.exercise.mapper.ExerciseMapper;
import kr.co.khedu.fitroutine.exercise.model.vo.ExerciseOpenData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class ExerciseService {
    private final ExerciseMapper exerciseMapper;

    public ExerciseService(ExerciseMapper exerciseMapper) {
        this.exerciseMapper = exerciseMapper;
    }

    public List<? extends ExerciseOpenData> getAllExerciseOpenDataList() {
        return exerciseMapper.getAllExerciseOpenDataList();
    }
}

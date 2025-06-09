package kr.co.khedu.fitroutine.exercise.mapper;

import kr.co.khedu.fitroutine.exercise.model.vo.ExerciseOpenData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExerciseMapper {
    List<? extends ExerciseOpenData> getAllExerciseOpenDataList();
}

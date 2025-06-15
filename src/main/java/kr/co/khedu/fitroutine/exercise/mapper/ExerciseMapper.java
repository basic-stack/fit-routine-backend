package kr.co.khedu.fitroutine.exercise.mapper;

import kr.co.khedu.fitroutine.todo.model.dto.RoutineInfo;
import kr.co.khedu.fitroutine.exercise.model.vo.ExerciseOpenData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExerciseMapper {
    List<? extends ExerciseOpenData> getAllExerciseOpenDataList(String purpose);

    List<? extends Integer> getRandomExerciseRoutine(int dayRepeat, String purpose);

    ExerciseOpenData getExerciseById(int id);

    int registExerciseRoutine(long memberId, RoutineInfo routineInfo);
}

package kr.co.khedu.fitroutine.todo.mapper;

import kr.co.khedu.fitroutine.exercise.model.dto.DailyExercises;
import kr.co.khedu.fitroutine.exercise.model.dto.ExerciseRoutineList;
import kr.co.khedu.fitroutine.todo.model.dto.RoutineInfo;
import kr.co.khedu.fitroutine.todo.model.dto.MyRank;
import kr.co.khedu.fitroutine.todo.model.dto.RoutineMvpTOP3;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.Nullable;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<? extends RoutineMvpTOP3> getRoutineMvpTOP3();

    @Nullable MyRank getRoutineMvpMyRank(long memberId);

    Long createRoutineInfo(long memberId, RoutineInfo routineInfo);

    @Nullable int getTodoIdByMemberId(long memberId);

    int insertDailyExercise(DailyExercises dailyExercises);

    int insertExerciseDetail(long dailyExerciseId, int exerciseId);

    int createExerciseRoutine(long memberId, ExerciseRoutineList exerciseRoutineList);
}

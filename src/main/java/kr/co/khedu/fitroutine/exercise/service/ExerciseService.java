package kr.co.khedu.fitroutine.exercise.service;

import kr.co.khedu.fitroutine.exercise.mapper.ExerciseMapper;
import kr.co.khedu.fitroutine.todo.model.dto.RoutineInfo;
import kr.co.khedu.fitroutine.exercise.model.dto.ExerciseRoutineList;
import kr.co.khedu.fitroutine.exercise.model.vo.ExerciseOpenData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class ExerciseService {
    private final ExerciseMapper exerciseMapper;

    public ExerciseService(ExerciseMapper exerciseMapper) {
        this.exerciseMapper = exerciseMapper;
    }

    public List<? extends ExerciseOpenData> getAllExerciseOpenDataList(String purpose) {
        return exerciseMapper.getAllExerciseOpenDataList(purpose);
    }

    // 운동 루틴 랜덤 추출
    public List<? extends Integer> getRandomExerciseRoutine(int dayRepeat, String purpose) {
        return exerciseMapper.getRandomExerciseRoutine(dayRepeat, purpose);
    }

    // 운동 루틴 랜덤 추출을 통해 Front에서 사용할 형태로 변환
    public ExerciseRoutineList getRandomExerciseRoutineTransform(int dayRepeat, String purpose) {
        List<Integer> randomExerciseList = (List<Integer>) getRandomExerciseRoutine(dayRepeat, purpose);
        /*
            0 : 0 ~ 4
            1 : 5 ~ 9
            2 : 10 ~ 14
            ...
            6 : 30 ~ 34
         */
        List<List<Integer>> exerciseList = new ArrayList<>();
        for (int i = 0; i < dayRepeat; i++) {
            int start = i * 5;
            int end = start + 5;

            exerciseList.add(randomExerciseList.subList(start, end));
        }
        return new ExerciseRoutineList(exerciseList);
    }

    public ExerciseOpenData getExerciseById(int id) {
        return exerciseMapper.getExerciseById(id);
    }

    public int registExerciseRoutine(long memberId, RoutineInfo routineInfo) {
        int result = exerciseMapper.registExerciseRoutine(memberId, routineInfo);
        if (exerciseMapper.registExerciseRoutine(memberId, routineInfo) <= 0) {
            throw new IllegalStateException("루틴을 등록할 수 없습니다.");
        }
        return result;
    }
}

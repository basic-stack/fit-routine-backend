package kr.co.khedu.fitroutine.exercise.controller;

import kr.co.khedu.fitroutine.exercise.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercises")
public final class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/open-data")
    public ResponseEntity<?> getAllExerciseOpenDataList() {
        return ResponseEntity.ok(exerciseService.getAllExerciseOpenDataList());
    }
}

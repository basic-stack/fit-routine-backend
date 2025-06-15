package kr.co.khedu.fitroutine.todo.controller;

import kr.co.khedu.fitroutine.exercise.model.dto.ExerciseRoutineList;
import kr.co.khedu.fitroutine.security.model.dto.UserDetailsImpl;
import kr.co.khedu.fitroutine.todo.model.dto.RoutineInfo;
import kr.co.khedu.fitroutine.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public final class TodoController {
    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/routine-rankings/monthly")
    public ResponseEntity<?> getRoutineMvpTOP3() {
        return ResponseEntity.ok(todoService.getRoutineMvpTOP3());
    }

    @GetMapping("/routine-rankings/monthly/me")
    public ResponseEntity<?> getRoutineMvpMyRank(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return ResponseEntity.ok(todoService.getgetRoutineMvpMyRank(userDetails.getMemberId()));
    }

    @PostMapping("/todos/info")
    public ResponseEntity<Long> createRoutineInfo(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody RoutineInfo routineInfo
    ){
        Long todoId = todoService.createRoutineInfo(userDetails.getMemberId(), routineInfo);
        if (todoId == 0L) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(todoId);
    }

    @PostMapping("/todos/exercises/{todoId}")
    public ResponseEntity<Void> createExerciseRoutine(
            @PathVariable long todoId,
            @RequestBody ExerciseRoutineList exerciseRoutineList
    ){
        todoService.createExerciseRoutine(todoId, exerciseRoutineList);
        return ResponseEntity.noContent().build();
    }
}

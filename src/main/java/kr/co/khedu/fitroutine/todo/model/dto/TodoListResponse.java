package kr.co.khedu.fitroutine.todo.model.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public final class TodoListResponse {
    private final long todoId;
    private final String category;
    private final Date title;
    private final Date description;

}

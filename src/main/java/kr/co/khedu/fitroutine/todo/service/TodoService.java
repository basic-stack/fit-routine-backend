package kr.co.khedu.fitroutine.todo.service;

import kr.co.khedu.fitroutine.todo.model.dto.MyRank;
import kr.co.khedu.fitroutine.todo.model.dto.RoutineMvpTOP3;
import kr.co.khedu.fitroutine.todo.mapper.TodoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoMapper todoMapper;
    public TodoService (TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    public List<? extends RoutineMvpTOP3> getRoutineMvpTOP3() {
        return todoMapper.getRoutineMvpTOP3();
    }

    public MyRank getgetRoutineMvpMyRank(long memberId) {
        MyRank myRank = todoMapper.getRoutineMvpMyRank(memberId);
        if (myRank == null) {
            myRank = MyRank.builder()
                    .rank(0)
                    .count(0)
                    .build();
        }
        return myRank;
    }
}

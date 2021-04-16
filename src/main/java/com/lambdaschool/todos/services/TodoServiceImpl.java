package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodoServiceImpl implements TodosService {

    @Autowired
    private TodosRepository todosrepo;

    @Transactional
    @Override
    public void markComplete(long todoid) {
        Todo todo =todosrepo.findById(todoid).orElseThrow(()-> new EntityNotFoundException("Todo "+todoid+" not found!"));
        todo.setCompleted(true);
    }
}


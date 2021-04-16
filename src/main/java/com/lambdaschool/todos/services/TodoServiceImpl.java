package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
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
        Todos todos =todosrepo.findById(todoid).orElseThrow(()-> new EntityNotFoundException("Todos "+todoid+" not found!"));
        todos.setCompleted(true);
    }
}


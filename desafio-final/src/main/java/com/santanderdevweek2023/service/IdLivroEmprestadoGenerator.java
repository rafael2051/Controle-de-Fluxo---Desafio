package com.santanderdevweek2023.service;

import org.springframework.stereotype.Component;

@Component
public class IdLivroEmprestadoGenerator {
    private static Integer nextId = 0;

    public Integer getNextId(){
        nextId++;
        return nextId;
    }
}

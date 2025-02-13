package org.lessons.java.spring_crud.repository;

import org.lessons.java.spring_crud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
   
}
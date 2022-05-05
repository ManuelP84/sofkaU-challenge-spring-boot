package com.sofkaU.toDoListchallengespringboot.repository;

import com.sofkaU.toDoListchallengespringboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

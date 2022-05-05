package com.sofkaU.toDoListchallengespringboot.repository;

import com.sofkaU.toDoListchallengespringboot.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}

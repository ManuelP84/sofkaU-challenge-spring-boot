package com.sofkaU.toDoListchallengespringboot.service;

import com.sofkaU.toDoListchallengespringboot.dto.CategoryDto;
import com.sofkaU.toDoListchallengespringboot.dto.NoteDto;
import com.sofkaU.toDoListchallengespringboot.entity.Category;
import com.sofkaU.toDoListchallengespringboot.entity.Note;

import java.util.List;

public interface CategoryNoteService {

    List<CategoryDto> getCategories();

    Category createCategory(CategoryDto categoryDto);

    Note createNote(NoteDto noteDto);

    Note updateNote(Note note);

    void deleteNote(Long id);

    void deleteCategory(Long id);

}

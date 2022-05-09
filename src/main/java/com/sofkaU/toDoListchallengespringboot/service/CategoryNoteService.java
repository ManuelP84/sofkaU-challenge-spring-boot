package com.sofkaU.toDoListchallengespringboot.service;

import com.sofkaU.toDoListchallengespringboot.dto.CategoryDto;
import com.sofkaU.toDoListchallengespringboot.dto.NoteDto;
import com.sofkaU.toDoListchallengespringboot.entity.Category;
import com.sofkaU.toDoListchallengespringboot.entity.Note;

import java.util.List;

public interface CategoryNoteService {

    List<CategoryDto> getCategories();

    CategoryDto createCategory(CategoryDto categoryDto);

    NoteDto createNote(NoteDto noteDto);

    NoteDto updateNote(NoteDto noteDto);

    void deleteNote(Long id);

    void deleteCategory(Long id);

}

package com.sofkaU.toDoListchallengespringboot.dao;

import com.sofkaU.toDoListchallengespringboot.entity.Category;
import com.sofkaU.toDoListchallengespringboot.entity.Note;

import java.util.List;

public interface CategoryNoteDao {

    List<Category> getCategories();

    Category createCategory(Category category);

    Note createNote(Note note);

    Note updateNote(Note note);

    void deleteNote(Note note);

    void deleteCategory(Category category);
}

package com.sofkaU.toDoListchallengespringboot.dao;


import com.sofkaU.toDoListchallengespringboot.entity.Category;
import com.sofkaU.toDoListchallengespringboot.entity.Note;
import com.sofkaU.toDoListchallengespringboot.repository.CategoryRepository;
import com.sofkaU.toDoListchallengespringboot.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryNoteDaoImplement implements CategoryNoteDao{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category createNote(Note note) {
        Long noteId = note.getFkCategoryId();
        Category category = categoryRepository.findById(noteId).get();
        category.addNote(note);
        noteRepository.save(note);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateNote(Note note) {
        return null;
    }

    @Override
    public void deleteNote(Note note) {
        noteRepository.deleteById(note.getId());
    }

    @Override
    public void deleteCategory(Category category) {
        Category categoryToBeDeleted = categoryRepository.findById(category.getId()).get();
        if(categoryToBeDeleted.getNotes().size() > 0){
            categoryToBeDeleted.getNotes().forEach(note -> noteRepository.deleteById(note.getId()));
        }
        categoryRepository.deleteById(category.getId());
    }
}

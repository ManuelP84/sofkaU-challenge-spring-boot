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
    public Note createNote(Note note) {
        Long categoryId = note.getFkCategoryId();
        Category category = categoryRepository.findById(categoryId).get();
        category.addNote(note);
        categoryRepository.save(category);

        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Note note) {
        noteRepository.deleteById(note.getId());
    }

    @Override
    public void deleteCategory(Long id) {
        Category categoryToBeDeleted = categoryRepository.findById(id).get();
        if(categoryToBeDeleted.getNotes().size() > 0){
            categoryToBeDeleted.getNotes().forEach(note -> noteRepository.deleteById(note.getId()));
        }
        categoryRepository.deleteById(id);
    }
}

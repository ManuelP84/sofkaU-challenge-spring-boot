package com.sofkaU.toDoListchallengespringboot.service;

import com.sofkaU.toDoListchallengespringboot.dao.CategoryNoteDaoImplement;
import com.sofkaU.toDoListchallengespringboot.entity.Category;
import com.sofkaU.toDoListchallengespringboot.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryNoteService {

    @Autowired
    private CategoryNoteDaoImplement categoryNoteService;

    public List<Category> getCategories(){
        return categoryNoteService.getCategories();
    }

    public Category createCategory(Category category){
        return categoryNoteService.createCategory(category);
    }

    public Note createNote(Note note){
        return categoryNoteService.createNote(note);
    }

    public Note updateNote(Note note){
        return categoryNoteService.updateNote(note);
    }

    public void deleteNote(Note note){
        categoryNoteService.deleteNote(note);
    }

    public void deleteCategory(Category category){
        categoryNoteService.deleteCategory(category);
    }
}

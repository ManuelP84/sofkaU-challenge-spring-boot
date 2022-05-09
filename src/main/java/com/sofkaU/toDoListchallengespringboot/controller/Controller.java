package com.sofkaU.toDoListchallengespringboot.controller;

import com.sofkaU.toDoListchallengespringboot.dto.CategoryDto;
import com.sofkaU.toDoListchallengespringboot.dto.NoteDto;
import com.sofkaU.toDoListchallengespringboot.entity.Category;
import com.sofkaU.toDoListchallengespringboot.entity.Note;
import com.sofkaU.toDoListchallengespringboot.service.CategoryNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class Controller {

    @Autowired
    private CategoryNoteService service;

    @GetMapping("get/categories")
    public List<CategoryDto> getAllCategories(){
        return service.getCategories();
    }

    @PostMapping("create/category")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto){
        return service.createCategory(categoryDto);
    }

    @PostMapping("create/note")
    public NoteDto createNote(@RequestBody NoteDto noteDto){
        return service.createNote(noteDto);
    }

    @PutMapping("update/note")
    public NoteDto updateNote(@RequestBody NoteDto noteDto){
        return service.updateNote(noteDto);
    }

    @DeleteMapping("delete/category/{id}")
    public void deleteCategory(@PathVariable Long id){
        service.deleteCategory(id);
    }

    @DeleteMapping("delete/note/{id}")
    public void deleteNote(@PathVariable Long id){
        service.deleteNote(id);
    }
}

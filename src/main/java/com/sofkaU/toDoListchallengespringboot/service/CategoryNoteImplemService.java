package com.sofkaU.toDoListchallengespringboot.service;


import com.sofkaU.toDoListchallengespringboot.dto.CategoryDto;
import com.sofkaU.toDoListchallengespringboot.dto.NoteDto;
import com.sofkaU.toDoListchallengespringboot.entity.Category;
import com.sofkaU.toDoListchallengespringboot.entity.Note;
import com.sofkaU.toDoListchallengespringboot.repository.CategoryRepository;
import com.sofkaU.toDoListchallengespringboot.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryNoteImplemService implements CategoryNoteService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;



    @Override
    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertCategoryToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category;
        category = convertDtoToCategory(categoryDto);
        return categoryRepository.save(category);
    }

    @Override
    public Note createNote(NoteDto noteDto) {
        Note note;
        note = convertDtoToNote(noteDto);
        Long categoryId = note.getFkCategoryId();
        Category category = categoryRepository.findById(categoryId).get();
        category.addNote(note);
        //categoryRepository.save(category);
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void deleteCategory(Long id) {
        Category categoryToBeDeleted = categoryRepository.findById(id).get();
        if(categoryToBeDeleted.getNotes().size() > 0){
            categoryToBeDeleted.getNotes().forEach(note -> noteRepository.deleteById(note.getId()));
        }
        categoryRepository.deleteById(id);
    }

    private NoteDto convertNoteToDto(Note note){
        NoteDto noteDto = new NoteDto();
        noteDto.setTitle(note.getTitle());
        noteDto.setDone(note.getDone());
        noteDto.setFkCategoryId(note.getFkCategoryId());
        noteDto.setId(note.getId());
        return noteDto;
    }

    // DTO Mapping
    private Note convertDtoToNote(NoteDto noteDto){
        Note note = new Note();
        note.setTitle(noteDto.getTitle());
        note.setDone(noteDto.getDone());
        note.setFkCategoryId(noteDto.getFkCategoryId());
        note.setId(noteDto.getId());
        return note;
    }

    private CategoryDto convertCategoryToDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setId(category.getId());
        categoryDto.setNotes(category.getNotes());
        return categoryDto;
    }

    private Category convertDtoToCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setId(categoryDto.getId());
        category.setNotes(categoryDto.getNotes());
        return category;
    }
}

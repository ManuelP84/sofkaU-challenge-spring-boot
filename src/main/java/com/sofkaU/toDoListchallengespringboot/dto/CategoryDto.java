package com.sofkaU.toDoListchallengespringboot.dto;

import com.sofkaU.toDoListchallengespringboot.entity.Note;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDto {

    private Long       id;
    private String     name;
    private List<Note> notes = new ArrayList<>();

}

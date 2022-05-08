package com.sofkaU.toDoListchallengespringboot.dto;

import lombok.Data;

@Data
public class NoteDto {

    private Long id;
    private String title;
    private Boolean done;
    private Long fkCategoryId;

}




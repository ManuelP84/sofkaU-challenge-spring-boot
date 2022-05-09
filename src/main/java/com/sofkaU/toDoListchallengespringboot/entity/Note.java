package com.sofkaU.toDoListchallengespringboot.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "Note")
@Table(name = "note")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    private Boolean done;

    //@NotEmpty
    private Long fkCategoryId;
}

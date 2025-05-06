package org.project.notespring.note;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Note {
    private long id;

    private String title;
    private String content;

}

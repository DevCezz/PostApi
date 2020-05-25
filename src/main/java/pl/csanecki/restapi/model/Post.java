package pl.csanecki.restapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Post {

    private long id;
    private String title;
    private String content;
    private LocalDateTime created;
}

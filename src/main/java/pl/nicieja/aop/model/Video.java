package pl.nicieja.aop.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Video {
    private long id;
    private String name;
    private String producer;
    private Long year;
}

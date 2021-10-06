package hu.flowacademy.blogpost.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "blogposts")
public class Blogpost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    private LocalDateTime createdAt;
    @ManyToMany
    /*@JoinTable(
            joinColumns = @JoinColumn(name = "blogpost_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id")
    )*/
    private Set<Category> categories;
}

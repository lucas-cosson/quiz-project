package com.lapireteam.quizzproject.entity;

import com.lapireteam.quizzproject.enumeration.Category;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="quiz_type")
public class Quiz extends AbstractPersistable<Long> {
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private User author;
    private Category category;
    private String difficulty;
    private String image;
    @OneToMany(mappedBy = "quiz")
    private Collection<Comment> comments = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}

package com.lapireteam.quizzproject.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Question extends AbstractPersistable<Long> {
    private String title;
    @OneToMany(mappedBy = "question")
    private Collection<Choice> choices = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="quiz_id", nullable=false)
    private SimpleQuiz quiz;

    public Question() {
    }
}

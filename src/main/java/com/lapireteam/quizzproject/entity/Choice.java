package com.lapireteam.quizzproject.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Choice extends AbstractPersistable<Long> {
    private String content;
    private Boolean isCorrect;
    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    private Question question;

    public Choice() {
    }
}

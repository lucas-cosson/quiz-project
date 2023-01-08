package com.lapireteam.quizzproject.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@DiscriminatorValue("QCM")
public class SimpleQuiz extends Quiz {
    @OneToMany(mappedBy = "quiz")
    private Collection<Question> questions = new ArrayList<>();

    public SimpleQuiz() {
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }
}

package com.tpe.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "t_answer")
public class Answer extends BaseEntity{
    @Column(nullable = false,length = 200)
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}

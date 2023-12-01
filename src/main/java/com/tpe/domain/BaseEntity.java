package com.tpe.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",sequenceName = "question_answer_seq",initialValue = 100,allocationSize = 5)
    private Long id;

    @Version
    private Long version;

    private LocalDateTime createOn=LocalDateTime.now();

    public Long getVersion() {
        return version;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

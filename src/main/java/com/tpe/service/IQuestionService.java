package com.tpe.service;

import com.tpe.domain.Question;

import java.util.List;

public interface IQuestionService {

    void saveQuestion(Question question);

    void updateQuestion(Question question);

    void deleteQuestion(Long id);

    Question findQuestion(Long id);

    List<Question> getAllQuestion();
}

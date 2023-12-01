package com.tpe.service;

import com.tpe.domain.Answer;

import java.util.List;

public interface IAnswerService {
    void saveAnswer(Answer answer);

    void updateAnswer(Answer answer);

    void deleteAnswer(Long id);

    Answer find(Long id);

    List<Answer> getAllAnswer();
    List<Answer> getAllAnswerByQuestionIG(Long id);
}

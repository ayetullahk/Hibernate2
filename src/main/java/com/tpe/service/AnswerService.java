package com.tpe.service;

import com.tpe.dao.AnswerDao;
import com.tpe.domain.Answer;
import com.tpe.exception.ResourceNotFoundException;

import java.util.List;

public class AnswerService implements IAnswerService{

    private static final AnswerDao answerDao=new AnswerDao();
    @Override
    public void saveAnswer(Answer answer) {
        answerDao.save(answer);

    }

    @Override
    public void updateAnswer(Answer answer) {
        answerDao.update(answer);

    }

    @Override
    public void deleteAnswer(Long id) {
        answerDao.delete(id);

    }

    @Override
    public Answer find(Long id) {
        return answerDao.find(id).orElseThrow(()->
                new ResourceNotFoundException("Answer not found id"+id));
    }

    @Override
    public List<Answer> getAllAnswer() {
        return answerDao.getAll();
    }

    @Override
    public List<Answer> getAllAnswerByQuestionIG(Long id) {
        return answerDao.findAllByQuestionId(id);
    }
}

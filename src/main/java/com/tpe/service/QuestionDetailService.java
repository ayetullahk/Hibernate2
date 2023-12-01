package com.tpe.service;

import com.tpe.dao.QuestionDetailDao;
import com.tpe.domain.QuestionDetail;
import com.tpe.exception.ResourceNotFoundException;

import java.util.List;

public class QuestionDetailService implements IQuestionDetailService {

    private static final QuestionDetailDao questionDetailDao = new QuestionDetailDao();

    @Override
    public void saveQuestionDetail(QuestionDetail questionDetail) {
        questionDetailDao.save(questionDetail);
    }

    @Override
    public void updateQuestionDetail(QuestionDetail questionDetail) {
        questionDetailDao.update(questionDetail);
    }

    @Override
    public void deleteQuestionDetail(Long id) {
        questionDetailDao.delete(id);
    }

    @Override
    public QuestionDetail find(Long id) {
        return questionDetailDao.find(id).orElseThrow(() ->
                new ResourceNotFoundException("QuestionDetail not found id" + id));
    }

    @Override
    public List<QuestionDetail> getAllQuestionDetail() {
        return questionDetailDao.getAll();
    }
}

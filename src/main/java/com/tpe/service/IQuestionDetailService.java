package com.tpe.service;

import com.tpe.domain.QuestionDetail;

import java.util.List;

public interface IQuestionDetailService {

    void saveQuestionDetail(QuestionDetail questionDetail);

    void updateQuestionDetail(QuestionDetail questionDetail);

    void deleteQuestionDetail(Long id);

    QuestionDetail find(Long id);

    List<QuestionDetail> getAllQuestionDetail();
}

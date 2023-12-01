package com.tpe;

import com.tpe.domain.Answer;
import com.tpe.domain.Question;
import com.tpe.domain.QuestionDetail;
import com.tpe.domain.enums.QuestionPriority;
import com.tpe.service.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.tpe.util.HibernateUtil;

import java.util.List;

public class Client {

    static IQuestionService qService = new QuestionService();
    static IQuestionDetailService qServiceDetail = new QuestionDetailService();
    static IAnswerService answerService = new AnswerService();

    public static void main(String[] args) {

//        Question question = new Question();
//        question.setName("What is Java");
//        question.setPriority(QuestionPriority.CRITICAL);

        Client client = new Client();

        //client.saveQuestion(question);

        Question questionFound = client.findQuestion(106L);
//        client.deleteQuestion(questionFound.getId());

//        QuestionDetail detail = new QuestionDetail();
//        detail.setDescription("It is about oop concept");
//        detail.setQuestion(questionFound);
//        client.saveQuestionDetail(detail);

//        Answer answer=new Answer();
//        answer.setName("Answer1");
//        answer.setDescription("There aare a fea relations such as: onetoone, onetomany, manytoone, manytomany");
//        answer.setQuestion(questionFound);

//        Answer answer2=new Answer();
//        answer2.setName("Answer2");
//        answer2.setDescription("You can create üni and bi directional onetoone relation");
//        answer2.setQuestion(questionFound);
//
//        client.saveAnswer(answer2);

//        Answer foundAnswer=client.findAnswer(116L);
//        foundAnswer.setName("Answer3");
//        client.updateAnswer(foundAnswer);
        List<Answer> answerList=client.findAnswerByQId(106L);
        System.out.println(answerList.size());


        HibernateUtil.getSessionFactory().close();

    }
    private List<Answer> findAnswerByQId(Long id){
        return answerService.getAllAnswerByQuestionIG(id);
    }

    private void saveAnswer(Answer answer){
        answerService.saveAnswer(answer);
    }
    private void updateAnswer(Answer answer){
        answerService.updateAnswer(answer);
    }

    private void saveQuestion(Question question) {
        qService.saveQuestion(question);
    }
    private  Answer findAnswer(Long id){
       return answerService.find(id);
    }

    private void deleteQuestion(Long id) {
        qService.deleteQuestion(id);
    }

    private Question findQuestion(Long id) {
        return qService.findQuestion(id);
    }

    private void saveQuestionDetail(QuestionDetail questionDetail) {
        qServiceDetail.saveQuestionDetail(questionDetail);
    }

//    public <T> void save(T t) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//
//        session.save(t);
//
//        tx.commit();
//        session.close();
//    }
//
//    public <T> T find(Long id, Class<T> c) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//
//        T t = (T) session.get(c, id);
//
//        tx.commit();
//        session.close();
//
//        return t;
//    }

}
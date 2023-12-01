package com.tpe.dao;

import com.tpe.domain.Answer;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.tpe.util.HibernateUtil;

import java.util.List;

public class AnswerDao extends HibernateDao<Answer>{

    public AnswerDao(){
        classType=Answer.class;
    }

    @Override
    public List<Answer> getAll() {
        Session session= HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery<Answer> criteriaQuery=cb.createQuery(Answer.class);
        Root<Answer> root=criteriaQuery.from(Answer.class);

        criteriaQuery.select(root);

        Query<Answer> query =session.createQuery(criteriaQuery);
        List<Answer> resultList=query.getResultList();
        session.close();

        return resultList;
    }

    public List<Answer> findAllByQuestionId(Long id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        Query<Answer> query= session.createQuery("from Answer  a where a.question.id=:questionId", Answer.class);
        query.setParameter("questionId",id);
        List<Answer>resultList=query.getResultList();
        tx.commit();
        session.close();
        return resultList;

    }
}

package com.tpe.dao;

import com.tpe.domain.Question;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.tpe.util.HibernateUtil;

import java.util.List;

public class QuestionDao extends HibernateDao<Question>{

    public QuestionDao(){
        classType= Question.class;
    }

    @Override
    public List<Question> getAll() {

        Session session= HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery=cb.createQuery(Question.class);
        Root<Question> root=criteriaQuery.from(Question.class);

        criteriaQuery.select(root);

        Query<Question> query =session.createQuery(criteriaQuery);
        List<Question> resultList=query.getResultList();

        return resultList;
    }
}

package com.tpe.dao;

import com.tpe.domain.QuestionDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.tpe.util.HibernateUtil;

import java.util.List;

public class QuestionDetailDao extends HibernateDao<QuestionDetail> {

    public QuestionDetailDao(){
        classType= QuestionDetail.class;
    }
    @Override
    public List<QuestionDetail> getAll() {
        Session session= HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery<QuestionDetail> criteriaQuery=cb.createQuery(QuestionDetail.class);
        Root<QuestionDetail> root=criteriaQuery.from(QuestionDetail.class);

        criteriaQuery.select(root);

        Query<QuestionDetail> query =session.createQuery(criteriaQuery);
        List<QuestionDetail> resultList=query.getResultList();

        session.close();

        return resultList;
    }
}

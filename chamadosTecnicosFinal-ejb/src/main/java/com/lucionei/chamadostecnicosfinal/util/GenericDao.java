package com.lucionei.chamadostecnicosfinal.util;

import com.lucionei.chamadostecnicosfinal.model.BaseEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Lucionei
 * @param <T>
 */
public class GenericDao<T extends BaseEntity> {

    private final EntityManager em;
    private final Class<T> type;

    public GenericDao(EntityManager em, Class<T> type) {
        this.em = em;
        this.type = type;
    }

    public T insert(T bean) {
        em.persist(bean);
        return bean;
    }

    public T update(T bean) {
        T auxBean = em.find(type, bean.getId());
        if (auxBean == null) {
            throw new EntityNotFoundException();
        }
       return em.merge(bean);
    }

    public void delete(Long id) {
        T bean = em.getReference(type, id);
        if (bean == null) {
            throw new EntityNotFoundException();
        }        
        em.remove(bean);
    }

    public List<T> findAll() {
        return em.createQuery(createCriteriaQuery()).getResultList();
    }

    private CriteriaQuery<T> createCriteriaQuery() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(type);
        query.from(type);
        return query;
    }

    public T findById(Long id) {
        T bean = em.find(type, id);
        if (bean == null) {
            throw new EntityNotFoundException();
        }
        return bean;
    }

}

package com.lucionei.chamadostecnicosfinal.service;

import com.lucionei.chamadostecnicosfinal.model.BaseEntity;
import com.lucionei.chamadostecnicosfinal.util.GenericDao;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.validation.Valid;

/**
 *
 * @author Lucionei
 * @param <T>
 */
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public abstract class AbstractService<T extends BaseEntity> {

    @Inject
    private GenericDao<T> dao;
    
    public List<T> findAll(int offset, int limit, String sort) {
        return dao.findAll();
    }
    
    public T findById(Long id) {
        return dao.findById(id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T insert(@Valid T obj) {
        return dao.insert(obj);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(Long id) {
        dao.delete(id);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T update(@Valid T obj){
        return dao.update(obj);
    }
}

/**
 * 
 */
package com.ams.service;

import java.io.Serializable;
import java.util.List;

import com.ams.model.BaseEntity;
import com.ams.model.exception.BusinessException;

/**
 * @createdBy: Anwar.Badr
 *
 */
public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {
	/**
	 * Create an entity in the DB
	 * @param entity
	 * @throws BusinessException
	 */
	T save (T entity) throws BusinessException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	Boolean deleteById(ID id) throws BusinessException;
	
	/**
	 * Get Element By ID
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	T getById(ID id) throws BusinessException;

	/**
	 * 
	 * @return
	 * @throws BusinessException
	 */
	List<T> findAll() throws BusinessException;
	
	
}

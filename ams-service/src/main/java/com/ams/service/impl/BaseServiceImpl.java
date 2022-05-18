/**
 * 
 */
package com.ams.service.impl;

import java.io.Serializable;
import java.util.List;

import com.ams.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ams.model.BaseEntity;
import com.ams.model.exception.BusinessException;
import com.ams.service.BaseService;

/**
 * @createdBy: Anwar.Badr
 *
 */
@Service
public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable>
		implements BaseService<T, ID> {

	@Autowired
	private BaseRepository<T, ID> baseRepository;


	@Override
	@Transactional
	public T save (T entity) throws BusinessException {
		return baseRepository.save(entity);
	}
	
	@Override
	@Transactional
	public Boolean deleteById(ID id) throws BusinessException {
		baseRepository.deleteById(id);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public T getById(ID id) throws BusinessException {
		return baseRepository.getOne(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<T> findAll() throws BusinessException {
		return baseRepository.findAll();
	}
	
}

package com.app.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.table.StoreDao;

@Repository
@Transactional(readOnly = true)
public interface StoreRepository extends CrudRepository<StoreDao, Long> {

	StoreDao findBySNameIgnoreCase(String sName);

	StoreDao findBySId(int sId);

	StoreDao findByFileNameIgnoreCase(String fileName);
	
}

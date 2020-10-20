package com.nosso.banco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nosso.banco.model.People;

public interface PeopleRepository extends CrudRepository<People, Long>  {
	
	@Query("select a from people a where a.id =?1 ")
	People findId(Long id);

}

package com.aime2code.springboot.veganfish.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aime2code.springboot.veganfish.entity.Breakfast;

@Repository
public class BreakfastDAOHibernateImpl implements BreakfastDAO{

	private EntityManager iEntityManager;
	
	@Autowired
	public BreakfastDAOHibernateImpl(EntityManager aEntityManager) {
		iEntityManager = aEntityManager;
	}
	
	@Override
	public List<Breakfast> findAll() {

		//get the current hibernate session
		Session lCurrentSession = iEntityManager.unwrap(Session.class);
		
		//create a query
		Query<Breakfast> lCreateQuery = lCurrentSession.createQuery("from Breakfast", Breakfast.class);
		
		//execute the query and get the result list
		List<Breakfast> lBreakfast = lCreateQuery.getResultList();
		
		//return the results
		return lBreakfast;
	}

	@Override
	public Breakfast findById(int aId) {
		
		//get the current hibernate session
		Session lCurrentSession = iEntityManager.unwrap(Session.class);
		
		//get the Breakfast
		Breakfast lBreakfast = lCurrentSession.get(Breakfast.class, aId);
		
		//return the breakfast
		return lBreakfast;
	}

	@Override
	public void save(Breakfast aBreakfast) {

		//get the current hibernate session
		Session lCurrentSession = iEntityManager.unwrap(Session.class);
		
		//save employee
		//Note: Remember if id = 0, then save/insert else update
		lCurrentSession.saveOrUpdate(aBreakfast);
	}

	@Override
	public void deleteById(int aId) {

		//get the current hibernate session
		Session lCurrentSession = iEntityManager.unwrap(Session.class);
		
		//delete object with primary key
		Query lQuery = lCurrentSession.createQuery("delete from Breakfast where id=:breakfastId");
		lQuery.setParameter("breakfastId", aId);
		
		lQuery.executeUpdate();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

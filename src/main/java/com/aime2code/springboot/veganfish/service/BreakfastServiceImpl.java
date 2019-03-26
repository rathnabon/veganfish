package com.aime2code.springboot.veganfish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aime2code.springboot.veganfish.dao.BreakfastDAO;
import com.aime2code.springboot.veganfish.entity.Breakfast;

@Service
public class BreakfastServiceImpl implements BreakfastService{

	private BreakfastDAO iBreakfastDAO;
	
	@Autowired
	public BreakfastServiceImpl(BreakfastDAO aBreakfastDAO) {
		iBreakfastDAO = aBreakfastDAO;
	}
	
	@Override
	@Transactional
	public List<Breakfast> findAll() {
		return iBreakfastDAO.findAll();
	}

	@Override
	@Transactional
	public Breakfast findById(int aId) {
		return iBreakfastDAO.findById(aId);
	}

	@Override
	@Transactional
	public void save(Breakfast aBreakfast) {

		iBreakfastDAO.save(aBreakfast);
	}

	@Override
	@Transactional
	public void deleteById(int aId) {

		iBreakfastDAO.deleteById(aId);
	}

	
}

package com.aime2code.springboot.veganfish.dao;

import java.util.List;

import com.aime2code.springboot.veganfish.entity.Breakfast;

public interface BreakfastDAO {

	public List<Breakfast> findAll();
	
	public Breakfast findById(int aId);
	
	public void save(Breakfast aBreakfast);
	
	public void deleteById(int aId);
	
	
}

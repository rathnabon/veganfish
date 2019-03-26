package com.aime2code.springboot.veganfish.service;

import java.util.List;

import com.aime2code.springboot.veganfish.entity.Breakfast;

public interface BreakfastService {

	public List<Breakfast> findAll();
	
	public Breakfast findById(int aId);
	
	public void save(Breakfast aBreakfast);
	
	public void deleteById(int aId);
}

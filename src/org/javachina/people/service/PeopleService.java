package org.javachina.people.service;

import java.util.ArrayList;

import org.javachina.people.dao.PeopleDao;
import org.javachina.people.dto.PeopleDto;

public class PeopleService {

	public ArrayList<PeopleDto> getAllPeople(){
		
		return new PeopleDao().queryAll();
	}
	public boolean deletePeople(int id){
		int i = new PeopleDao().deleteById(id);
		if(i==0){
			return false;
		}
		return true;
	}
	public boolean addPeople(PeopleDto dto){
		int i= new PeopleDao().add(dto);
		if(i==0){
			return false;
		}
		return true;
	}
}

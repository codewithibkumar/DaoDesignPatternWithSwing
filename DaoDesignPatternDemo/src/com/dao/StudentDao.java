package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class StudentDao {

	ArrayList<Student> list = new ArrayList<Student>();
	public void save(Student obj)
	{
		list.add(obj);
		//ps.setInt(1, obj.getRoll());
		//ps.setString(2, obj.getName());
		
		
	}
	public List<Student> students()
	{
		return list;
	}
	public void delete(int roll)
	{
		Student temp = null;
		for(Student k : list)
		{
			if(k.getRoll() == roll)
				temp = k;
		}
		if(temp != null)
			list.remove(temp);
		else
			System.out.println("Sorry student not found");
		
	}
	public Student search(int roll)
	{
		Student temp = null;
		for(Student k : list)
		{
			if(k.getRoll() == roll)
				temp = k;
		}
		return temp;
		
	
	}
}

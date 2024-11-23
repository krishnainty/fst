package com.m4;

public class Course {
	Integer id;
	String name;
	String domain;
	
	Course()
	{
		
	}
	
	Course(Integer id, String name, String domain)
	{
		this.id=id;
		this.name=name;
		this.domain=domain;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDomain()
	{
		return domain;
	}
	
	public void setId(Integer id)
	{
		this.id=id;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setDomain(String domain)
	{
		this.domain=domain;
	}
}

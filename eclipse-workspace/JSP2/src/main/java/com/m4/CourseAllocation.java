package com.m4;

import java.util.Optional;

public class CourseAllocation {
	
	public Optional<Course> getCid(int id)
	{
		switch(id)
		{
		case 1:
			return Optional.of(new  Course(1,"Devops","CSE"));
		case 2:
			return Optional.of(new Course(2,"Deep learning","CSE"));
		case 3:
			return Optional.of(new Course(3,"SPM","CSE"));
		case 4:
			return Optional.of(new Course(4,"Management Science","MBA"));
			default:
				return Optional.empty();
		}
	}
}

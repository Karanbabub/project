package com.springboot.model;

import java.util.HashMap;
import java.util.Map;

public enum Category
{
	LAPTOP(0), MOBILES(1), PLAYSTATION(2);

	private int value;
	private static Map<Object, Object> map = new HashMap<>();

	private Category(int value)
	{
		this.value = value;
	}

	 static
	{
		for (Category category : Category.values())
		{
			map.put(category.value, category);
		}
	}

	public static Category valueOf(int category)
	{
		return (Category) map.get(category);
	}

	public int getValue()
	{
		return value;
	}

	

	
	
}

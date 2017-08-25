package com.github.jmodel.adapter.persistence.exampleA;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.Persister;
import com.github.jmodel.adapter.persistence.exampleA.domain.User;

public class MyBatisMySqlExample {

	public static void main(String[] args) {
		
		try {
			Persister.insertObject("insert", new User());
		
		} catch (AdapterException e) {
			
			e.printStackTrace();
		}
	}

}

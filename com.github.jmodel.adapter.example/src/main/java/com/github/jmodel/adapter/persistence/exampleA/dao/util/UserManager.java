package com.github.jmodel.adapter.persistence.exampleA.dao.util;

import com.github.jmodel.adapter.persistence.exampleA.DatabaseOperation;
import com.github.jmodel.adapter.persistence.exampleA.dao.bean.User;
import com.github.jmodel.adapter.persistence.exampleA.dao.mapper.UserMapper;

public class UserManager {

	public static Long insertUser(final User user) {

		return (Long) new DatabaseOperation(true) {

			@Override
			public Object performAction() {
				executeMapperFunction(UserMapper.class, "insertUser", user);
				return user.getId();
			}
		}.invoke();
	}

}

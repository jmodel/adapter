package com.github.jmodel.adapter.persistence.exampleA.action;

import java.util.function.BiFunction;

import org.apache.ibatis.session.SqlSession;

import com.github.jmodel.adapter.persistence.exampleA.domain.User;
import com.github.jmodel.adapter.persistence.exampleA.mapper.UserMapper;

public class InsertUser implements BiFunction<SqlSession, User, Long> {

	@Override
	public Long apply(SqlSession t, User u) {

		UserMapper userMapper = t.getMapper(UserMapper.class);
		userMapper.insertUser(u);
		return null;
	}

}

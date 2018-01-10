package com.github.jmodel.adapter.persistence.exampleA.dao;

import org.apache.ibatis.session.SqlSession;

import com.github.jmodel.adapter.impl.persistence.Action;
import com.github.jmodel.adapter.persistence.exampleA.dao.bean.User;
import com.github.jmodel.adapter.persistence.exampleA.dao.mapper.UserMapper;

public class InsertUser implements Action<SqlSession, User, Long> {

	@Override
	public Long apply(SqlSession sqlSession, User user) {

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUser(user);
		return user.getId();
	}

}

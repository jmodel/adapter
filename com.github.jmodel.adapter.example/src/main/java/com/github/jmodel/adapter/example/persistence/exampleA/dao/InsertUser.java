package com.github.jmodel.adapter.example.persistence.exampleA.dao;

import org.apache.ibatis.session.SqlSession;

import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.adapter.example.AdapterExampleTerms;
import com.github.jmodel.adapter.example.persistence.exampleA.dao.bean.User;
import com.github.jmodel.adapter.example.persistence.exampleA.dao.mapper.UserMapper;
import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.japp.api.AbstractAction;

public class InsertUser extends AbstractAction implements Action<SqlSession, User, Long> {

	@Override
	public Long apply(SqlSession sqlSession, User user) {

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUser(user);
		return user.getId();
	}

	@Override
	public Term getItemTerm() {
		return tfs.getTerm(AdapterExampleTerms.INSERT_USER);
	}

}

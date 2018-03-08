package com.github.jmodel.adapter.example.persistence.exampleA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;

import com.github.jmodel.adapter.Logger;
import com.github.jmodel.adapter.Persister;
import com.github.jmodel.adapter.example.AdapterExampleTerms;
import com.github.jmodel.adapter.example.config.ExampleConfigurationLoader;
import com.github.jmodel.adapter.example.persistence.exampleA.dao.bean.User;
import com.github.jmodel.adapter.impl.persistence.mybatis.ConnectionFactory;
import com.github.jmodel.japp.utils.JappUtil;

public class MyBatisH2PersisterAdapter {

	static {
		ExampleConfigurationLoader.getInstance().load();
	}

	private final static Logger logger = Logger.getLogger(MyBatisH2PersisterAdapter.class.getName());

	public static void main(String[] args) {

		SqlSession session = null;

		try {

			//////////////////////////////////////
			Connection connection = DriverManager.getConnection("jdbc:h2:mem:db1");
			Statement s = connection.createStatement();
			try {
				s.execute("DROP TABLE T_USER");
			} catch (SQLException sqle) {

			}
			s.execute("CREATE TABLE T_USER (ID BIGINT AUTO_INCREMENT, NAME VARCHAR(50), CODE VARCHAR(50))");
			s.close();
			/////////////////////////////////////

			session = ConnectionFactory.getSqlSessionFactory().openSession();

			User user = new User();
			user.setName("jianni");
			user.setCode("JN");
			Persister persister = Persister.getPersister();
			Long userId = persister.insertObject(session, JappUtil.getAction(AdapterExampleTerms.INSERT_USER), user);

			logger.info("The new user id is : " + userId);
			session.commit();

			connection.close();

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}

package com.github.jmodel.adapter.impl.persistence.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConnectionFactory {
	
    private static Reader reader;
    private static SqlSessionFactory sqlMapper;

    static {
        try {
            reader = Resources.getResourceAsReader("database-config.xml");
            sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlMapper;
    }
}

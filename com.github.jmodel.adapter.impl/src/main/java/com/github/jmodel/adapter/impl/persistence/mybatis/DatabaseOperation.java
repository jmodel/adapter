package com.github.jmodel.adapter.persistence.exampleA;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public abstract class DatabaseOperation {

	private boolean commitNeeded = false;
	private SqlSession session;

	public DatabaseOperation() {
		this(false);
	}

	public DatabaseOperation(final boolean commit) {
		commitNeeded = commit;
	}

	public Object executeMapperFunction(final Class<?> mapperClass, final String operation) {
		return executeMapperFunction(mapperClass, operation, new Object[] {});
	}

	public Object executeMapperFunction(final Class<?> mapperClass, final String action, final Object args[]) {

		final Class<?> c = mapperClass;
		Method behave = null;
		final Object mapper = session.getMapper(c);
		final Class<?> paramTypes[] = new Class[args.length];
		Object retObj = null;
		for (int i = 0; i < args.length; i++) {
			paramTypes[i] = args[i].getClass();
		}

		try {
			behave = c.getMethod(action, paramTypes);
			retObj = behave.invoke(mapper, args);
		} catch (final SecurityException e) {
			e.printStackTrace();
		} catch (final NoSuchMethodException e) {
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			e.printStackTrace();
		}

		return retObj;
	}

	public Object executeMapperFunction(final Class<?> mapperClass, final String operation, final Object obj) {
		return executeMapperFunction(mapperClass, operation, new Object[] { obj });
	}

	public Object executeMapperFunction(final Class<?> mapperClass, final String action, final Object obj,
			final RowBounds rowBounds) {

		final Class<?> c = mapperClass;
		Method behave = null;
		final Object mapper = session.getMapper(c);
		Object retObj = null;
		try {
			behave = c.getMethod(action, obj.getClass(), rowBounds.getClass());
			retObj = behave.invoke(mapper, obj, rowBounds);
		} catch (final SecurityException e) {
			e.printStackTrace();
		} catch (final NoSuchMethodException e) {
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			e.printStackTrace();
		}

		return retObj;
	}

	public SqlSession getSession() {
		return session;
	}

	public Object invoke() {

		Object retObject = null;

		try {
			if (session == null) {
				session = ConnectionFactory.getSqlSessionFactory().openSession();
			}

			retObject = performAction();

			if (commitNeeded) {
				session.commit();
			}
		} finally {
			session.close();
		}

		return retObject;
	}

	public abstract Object performAction();

	public void setSession(final SqlSession session) {
		this.session = session;
	}
}

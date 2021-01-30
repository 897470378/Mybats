package com.sikiedu.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sikiedu.mapper.FindUser;

public class DBTools {
	public static SqlSessionFactory sessionFactory;

	static {
		try {
			// ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			// ����sqlSession�Ĺ���
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ������ִ��ӳ���ļ���sql��sqlSession
	public static SqlSession getSession() {
		return sessionFactory.openSession();
	}

	public static void main(String[] args) throws Exception {
		SqlSession s = DBTools.getSession();
		FindUser f = s.getMapper(FindUser.class);

		System.out.println(f.queryById(0));
		System.out.println(f.queryById(1));
		System.out.println(f.queryById(2));
	}
}

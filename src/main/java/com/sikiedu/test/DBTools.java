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
			// 使用MyBatis提供的Resources类加载mybatis的配置文件
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			// 构建sqlSession的工厂
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 创建能执行映射文件中sql的sqlSession
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

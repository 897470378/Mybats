package com.sikiedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sikiedu.beans.User;

public interface FindUser {
	void insertUser(@Param("list") List<User> lists);
	
	List<User> queryById(@Param("id") Integer id);
}

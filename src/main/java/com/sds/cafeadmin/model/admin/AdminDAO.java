package com.sds.cafeadmin.model.admin;

import java.lang.reflect.Member;

import org.apache.ibatis.annotations.Mapper;

import com.sds.cafeadmin.domain.Admin;

@Mapper
public interface AdminDAO {
	public int insert(Admin admin);
	public Admin selectByUid(String uid);
	public void update(Member member);

}

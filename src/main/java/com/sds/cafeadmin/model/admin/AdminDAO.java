package com.sds.cafeadmin.model.admin;

import org.apache.ibatis.annotations.Mapper;

import com.sds.cafeadmin.domain.Admin;

@Mapper
public interface AdminDAO {
	public int insert(Admin admin);
	public Admin selectByUid(String uid);

}

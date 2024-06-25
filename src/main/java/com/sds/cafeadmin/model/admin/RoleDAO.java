package com.sds.cafeadmin.model.admin;

import org.apache.ibatis.annotations.Mapper;

import com.sds.cafeadmin.domain.Role;

@Mapper
public interface RoleDAO {
	public Role selectByName(String role_name);
}
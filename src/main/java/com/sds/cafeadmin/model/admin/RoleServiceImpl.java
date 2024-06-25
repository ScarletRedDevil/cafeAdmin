package com.sds.cafeadmin.model.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.cafeadmin.domain.Role;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDAO roleDAO;
	
	public Role selectByName(String Role_name) {
		
		return roleDAO.selectByName(Role_name);
	}

}

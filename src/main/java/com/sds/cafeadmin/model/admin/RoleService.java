package com.sds.cafeadmin.model.admin;

import com.sds.cafeadmin.domain.Role;

public interface RoleService {

	public Role selectByName(String Role_name);
}

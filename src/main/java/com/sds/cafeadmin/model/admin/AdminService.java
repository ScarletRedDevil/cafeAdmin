package com.sds.cafeadmin.model.admin;

import com.sds.cafeadmin.domain.Admin;

public interface AdminService {
	public void regist(Admin admin); // 회원등록

	public Admin selectByUid(String uid);// uid 에 해당하는 회원정보 가져오기
}

package com.sds.cafeadmin.model.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sds.cafeadmin.domain.Admin;
import com.sds.cafeadmin.exception.AdminException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public void regist(Admin admin) {
		

		int result = adminDAO.insert(admin);

		if (result < 1) {
			throw new AdminException("오류 : 회원등록 실패");
		}

		// 회원 정보 등록
		
		log.debug("회원 상세정보에 들어갈 member_idx is " + admin.getAdmin_idx());

//		admin.setPassword(bCryptPasswordEncoder.encode(admin.getPwd()));

		result = adminDAO.insert(admin);// 회원 상세 정보 등록
		if (result < 1) {
			throw new AdminException("회원 추가정보 등록 실패");
		}

	}

	public Admin selectByUid(String uid) {
		return adminDAO.selectByUid(uid);
	}

}

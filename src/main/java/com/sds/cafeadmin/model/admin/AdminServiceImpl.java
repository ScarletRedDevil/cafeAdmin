package com.sds.cafeadmin.model.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sds.cafeadmin.domain.Admin;
import com.sds.cafeadmin.domain.Role;
import com.sds.cafeadmin.exception.AdminException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;
    
    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void regist(Admin admin) {
        // 회원의 권한 가져오기
        Role role = roleDAO.selectByName(admin.getRole().getRole_name());
        admin.setRole(role); // role_idx가 채워진 DTO를 다시 Admin DTO에 대입
        
        // 비밀번호를 암호화
        admin.setPwd(bCryptPasswordEncoder.encode(admin.getPwd()));
        
        // 회원 정보 등록
        int result = adminDAO.insert(admin);
        if (result < 1) {
            throw new AdminException("오류 : 회원등록 실패");
        }
        
        log.debug("회원 상세정보에 들어갈 admin_idx is " + admin.getAdmin_idx());
    }

    public Admin selectByUid(String uid) {
        return adminDAO.selectByUid(uid);
    }
}

package com.cly.mara.service;

import com.cly.mara.bean.UserInfoBean;

import java.util.List;

public interface UserInfoService {
    List<UserInfoBean> getUserInfoBeanList() throws Exception;
    List<UserInfoBean> getUserInfoBeanList(String post) throws Exception;
    UserInfoBean login(String userName, String password) throws Exception;
    UserInfoBean getUserInfo(int uid) throws Exception;
    boolean addUserInfo(UserInfoBean userInfoBean);
    boolean updateUserInfo(UserInfoBean userInfoBean);
}

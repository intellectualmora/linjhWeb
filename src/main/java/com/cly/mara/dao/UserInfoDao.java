package com.cly.mara.dao;

import com.cly.mara.bean.UserInfoBean;

import java.util.List;

public interface UserInfoDao {
    List<UserInfoBean> fetchUserInfoList()throws Exception;
    UserInfoBean fetchUserInfo(int uid) throws Exception;
    boolean addUserInfo(UserInfoBean userInfoBean);
    boolean updateUserInfo(UserInfoBean userInfoBean);
}

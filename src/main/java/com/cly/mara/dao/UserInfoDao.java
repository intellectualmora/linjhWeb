package com.cly.mara.dao;

import com.cly.mara.bean.UserInfoBean;

import java.util.List;

public interface UserInfoDao {
    List<UserInfoBean> fetchUserInfoList()throws Exception;
    List<UserInfoBean> fetchUserInfoList(String post)throws Exception;
    UserInfoBean fetchUserInfo(int uid) throws Exception;

    boolean addUserInfo(UserInfoBean userInfoBean);
    boolean updateUserInfo(UserInfoBean userInfoBean);
}

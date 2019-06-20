package com.cly.mara.service;

import com.cly.mara.bean.UserInfoBean;
import com.cly.mara.dao.UserInfoDao;
import com.cly.mara.dao.UserInfoDaoImpl;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    UserInfoDao userInfoDao = new UserInfoDaoImpl();
    @Override
    public List<UserInfoBean> getUserInfoBeanList() throws Exception {
        return userInfoDao.fetchUserInfoList();
    }

    @Override
    public List<UserInfoBean> getUserInfoBeanList(String post) throws Exception {
        return userInfoDao.fetchUserInfoList(post);
    }

    @Override
    public UserInfoBean login(String userName, String password) throws Exception {
        return userInfoDao.fetchUserInfo(userName,password);
    }

    @Override
    public UserInfoBean getUserInfo(int uid) throws Exception {
        return userInfoDao.fetchUserInfo(uid);
    }

    @Override
    public boolean addUserInfo(UserInfoBean userInfoBean) {
        return userInfoDao.addUserInfo(userInfoBean);
    }

    @Override
    public boolean updateUserInfo(UserInfoBean userInfoBean) {
        return userInfoDao.updateUserInfo(userInfoBean);
    }
}

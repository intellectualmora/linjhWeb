package com.cly.mara.dao;

import com.cly.mara.bean.InterestBean;

import java.util.List;

public interface InterestDao {
    List<InterestBean> fetchInterestBeanList(int uid) throws Exception;
}

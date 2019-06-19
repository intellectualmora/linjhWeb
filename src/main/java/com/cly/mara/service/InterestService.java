package com.cly.mara.service;

import com.cly.mara.bean.InterestBean;

import java.util.List;

public interface InterestService {
    List<InterestBean> getInterestBeanList(int uid) throws Exception;
}

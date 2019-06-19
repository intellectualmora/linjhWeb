package com.cly.mara.service;

import com.cly.mara.bean.InterestBean;
import com.cly.mara.dao.InterestDao;
import com.cly.mara.dao.InterestDaoImpl;

import java.util.List;

public class InterestServiceImpl implements InterestService {
    InterestDao interestDao = new InterestDaoImpl();
    @Override
    public List<InterestBean> getInterestBeanList(int uid) throws Exception {
        return interestDao.fetchInterestBeanList(uid);
    }
}

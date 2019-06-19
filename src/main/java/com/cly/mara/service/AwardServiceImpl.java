package com.cly.mara.service;

import com.cly.mara.bean.AwardBean;
import com.cly.mara.dao.AwardDao;
import com.cly.mara.dao.AwardDaoImpl;

import java.util.List;

public class AwardServiceImpl implements AwardService  {
    private AwardDao awardDao = new AwardDaoImpl();

    @Override
    public List<AwardBean> getAwardBeanList(int uid) throws Exception {
        return awardDao.fetchAwardBeanList(uid);
    }
}

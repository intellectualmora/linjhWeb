package com.cly.mara.service;

import com.cly.mara.bean.EducationBean;
import com.cly.mara.dao.EducationDao;
import com.cly.mara.dao.EducationDaoImpl;

import java.util.List;

public class EducationServiceImpl implements EducationService {
    private EducationDao educationDao = new EducationDaoImpl();
    @Override
    public List<EducationBean> getEducationList(int uid) throws Exception {
        return educationDao.fetchEducationBeanList(uid);
    }
}

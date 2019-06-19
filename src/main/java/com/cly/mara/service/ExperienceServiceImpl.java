package com.cly.mara.service;

import com.cly.mara.bean.ExperienceBean;
import com.cly.mara.dao.ExperienceDao;
import com.cly.mara.dao.ExperienceDaoImpl;

import java.util.List;

public class ExperienceServiceImpl implements ExperienceService {
    ExperienceDao experienceDao = new ExperienceDaoImpl();
    @Override
    public List<ExperienceBean> getExperienceBeanList(int uid) throws Exception {
        return experienceDao.fetchExperienceBeanList(uid);
    }
}

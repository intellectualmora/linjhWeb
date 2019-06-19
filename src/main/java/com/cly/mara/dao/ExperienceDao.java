package com.cly.mara.dao;

import com.cly.mara.bean.ExperienceBean;

import java.util.List;

public interface ExperienceDao {
    List<ExperienceBean> fetchExperienceBeanList(int uid) throws Exception;
}

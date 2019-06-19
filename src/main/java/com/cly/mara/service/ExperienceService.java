package com.cly.mara.service;

import com.cly.mara.bean.ExperienceBean;

import java.util.List;

public interface ExperienceService {
    List<ExperienceBean> getExperienceBeanList(int uid) throws Exception;
}

package com.cly.mara.dao;

import com.cly.mara.bean.EducationBean;

import java.util.List;

public interface EducationDao {
    List<EducationBean> fetchEducationBeanList(int uid) throws Exception;
}

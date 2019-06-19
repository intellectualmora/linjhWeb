package com.cly.mara.service;

import com.cly.mara.bean.EducationBean;

import java.util.List;

public interface EducationService {
    List<EducationBean> getEducationList(int uid) throws Exception;
}

package com.cly.mara.service;

import com.cly.mara.bean.AwardBean;

import java.util.List;

public interface AwardService {
    List<AwardBean> getAwardBeanList(int uid) throws Exception;
}

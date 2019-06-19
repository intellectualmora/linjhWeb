package com.cly.mara.dao;

import com.cly.mara.bean.AwardBean;

import java.util.List;

public interface AwardDao {
    List<AwardBean> fetchAwardBeanList(int uid) throws Exception;
}

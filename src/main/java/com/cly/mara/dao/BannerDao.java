package com.cly.mara.dao;

import com.cly.mara.bean.BannerBean;

import java.util.List;

public interface BannerDao {
    List<BannerBean> fetchBannerBeanList() throws Exception;
}

package com.cly.mara.service;

import com.cly.mara.bean.BannerBean;

import java.util.List;

public interface BannerService {
    List<BannerBean> getRecentBannerBeanList() throws Exception;
}

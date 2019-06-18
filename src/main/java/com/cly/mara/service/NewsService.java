package com.cly.mara.service;

import com.cly.mara.bean.NewsBean;

import java.util.List;

public interface NewsService {
    List<NewsBean> getRecentNews() throws Exception;
    List<NewsBean> getNewsList() throws Exception;
}

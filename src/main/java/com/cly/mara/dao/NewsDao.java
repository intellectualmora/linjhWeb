package com.cly.mara.dao;

import com.cly.mara.bean.NewsBean;

import java.util.List;

public interface NewsDao {
    List<NewsBean> fetchNewsList()throws Exception;
    NewsBean fetchNews(int nid)throws Exception;
    boolean addNews(NewsBean newsBean);
    boolean updateNews(NewsBean newsBean);
}

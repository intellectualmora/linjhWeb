package com.cly.mara.dao;

import com.cly.mara.bean.NewsBean;

import java.util.List;

public interface NewsDao {
    List<NewsBean> fetchNewsList()throws Exception;
    NewsBean fetchNews(int aid)throws Exception;
    boolean addArticle(NewsBean article);
}

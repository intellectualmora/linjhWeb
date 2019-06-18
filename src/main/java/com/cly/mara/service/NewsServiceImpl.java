package com.cly.mara.service;

import com.cly.mara.bean.NewsBean;
import com.cly.mara.dao.NewsDao;
import com.cly.mara.dao.NewsDaoImpl;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    private NewsDao newsDao = new NewsDaoImpl();
    @Override
    public List<NewsBean> getRecentNews() throws Exception {
        List<NewsBean> newsBeans = newsDao.fetchNewsList();
        if(newsBeans.size()>4){
            newsBeans = newsBeans.subList(0,4);
        }
        return newsBeans;
    }

    @Override
    public List<NewsBean> getNewsList() throws Exception {
        List<NewsBean> newsBeans = newsDao.fetchNewsList();
        return newsBeans;
    }

}

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
        return newsDao.fetchNewsList();
    }

    @Override
    public NewsBean getNews(int nid) throws Exception {
        return newsDao.fetchNews(nid);
    }

    @Override
    public boolean addNews(NewsBean newsBean) {
        return newsDao.addNews(newsBean);
    }

    @Override
    public boolean updateNews(NewsBean newsBean) {
        return newsDao.updateNews(newsBean);
    }


}

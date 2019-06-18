package com.cly.mara.dao;

import com.cly.mara.bean.ArticleBean;

import java.util.List;

public interface ArticleDao {
    List<ArticleBean> fetchArticleList()throws Exception;
    List<ArticleBean> fetchArticleList(int uid)throws Exception;
    ArticleBean fetchArticle(int aid)throws Exception;
    boolean addArticle(ArticleBean article);
}

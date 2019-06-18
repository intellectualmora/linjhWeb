package com.cly.mara.dao;

import com.cly.mara.bean.NewsBean;
import com.cly.mara.util.ConnectDB;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NewsDaoImpl implements NewsDao {
    ConnectDB dbutil = new ConnectDB();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Statement statement = null;
    ResultSetMetaData metaData = null;

    @Override
    public List<NewsBean> fetchNewsList() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<NewsBean> newsBeanList=new ArrayList<>();
        connection = dbutil.getConnection();
        String sql="select * from News n ";
        preparedStatement=connection.prepareStatement(sql);
        resultSet=preparedStatement.executeQuery();

        while(resultSet.next()){
            int _nid = resultSet.getInt("nid");
            String imgSrc = resultSet.getString("imgSrc");
            String content = resultSet.getString("content");
            String title = resultSet.getString("title");
            String date = resultSet.getString("date");
            NewsBean newsBean = new NewsBean();
            newsBean.setContent(content);
            newsBean.setImgSrc(imgSrc);
            newsBeanList.add(newsBean);
        }
        dbutil.closeDBResource(connection, preparedStatement, resultSet);
        return newsBeanList;
    }

    @Override
    public NewsBean fetchNews(int aid) throws Exception {
        return null;
    }

    @Override
    public boolean addArticle(NewsBean article) {
        return false;
    }
}

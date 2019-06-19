package com.cly.mara.dao;

import com.cly.mara.bean.PublicationBean;
import com.cly.mara.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublicationDaoImpl implements PublicationDao {
    ConnectDB dbutil = new ConnectDB();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Statement statement = null;
    ResultSetMetaData metaData = null;
    @Override
    public List<PublicationBean> fetchPublicationList() throws Exception {
        List<PublicationBean> publicationBeanList =new ArrayList<>();
        connection = dbutil.getConnection();
        String sql="select * from Publication p order by pid desc";
        preparedStatement=connection.prepareStatement(sql);
        resultSet=preparedStatement.executeQuery();

        while(resultSet.next()){
            int pid = resultSet.getInt("pid");
            String imgSrc = resultSet.getString("imgSrc");
            String content = resultSet.getString("content");
            String pName = resultSet.getString("pName");
            int year = resultSet.getInt("year");
            int uid = resultSet.getInt("uid");

            PublicationBean publicationBean = new PublicationBean();
            publicationBean.setContent(content);
            publicationBean.setImgSrc(imgSrc);
            publicationBean.setYear(year);
            publicationBean.setUid(uid);
            publicationBean.setpName(pName);
            publicationBean.setPid(pid);

            publicationBeanList.add(publicationBean);

        }
        dbutil.closeDBResource(connection, preparedStatement, resultSet);
        return publicationBeanList;
    }

    @Override
    public List<PublicationBean> fetchPublicationList(int year) throws Exception {
        return null;
    }

    @Override
    public PublicationBean fetchPublication(int pid) throws Exception {
            return null;
    }

    @Override
    public boolean addAPublication(PublicationBean article) {
        return false;
    }

    @Override
    public boolean updatePublication(PublicationBean article) {
        return false;
    }
}

package com.cly.mara.dao;

import com.cly.mara.bean.ResourceBean;
import com.cly.mara.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceDaoImpl implements ResourceDao {
    ConnectDB dbutil = new ConnectDB();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Statement statement = null;
    ResultSetMetaData metaData = null;

    List<ResourceBean> resourceBeanList = null;
    ResourceBean resourceBean = null;
    @Override
    public List<ResourceBean> fetchResourceBeanList() throws Exception {
        resourceBeanList = new ArrayList<>();
        connection = dbutil.getConnection();
        String sql="select * from Resource r";
        preparedStatement=connection.prepareStatement(sql);
        resultSet=preparedStatement .executeQuery();

        while(resultSet.next()){
            int pid = resultSet.getInt("resid");
            String imgSrc = resultSet.getString("imgSrc");
            String pName = resultSet.getString("pName");
            String pNameC = resultSet.getString("pNameC");


            resourceBean = new ResourceBean();
            resourceBean.setResid(pid);
            resourceBean.setImgSrc(imgSrc);
            resourceBean.setpName(pName);
            resourceBean.setpNameC(pNameC);

            resourceBeanList.add(resourceBean);

        }
        dbutil.closeDBResource(connection, preparedStatement, resultSet);
        return resourceBeanList;
    }
}

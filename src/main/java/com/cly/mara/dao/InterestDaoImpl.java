package com.cly.mara.dao;

import com.cly.mara.bean.InterestBean;
import com.cly.mara.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InterestDaoImpl implements InterestDao{
    ConnectDB dbutil = new ConnectDB();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Statement statement = null;
    ResultSetMetaData metaData = null;
    @Override
    public List<InterestBean> fetchInterestBeanList(int uid) throws Exception {
        List<InterestBean> interestBeanList = new ArrayList<>();
        connection = dbutil.getConnection();
        String sql="select * from Interest i where uid = ?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,uid);
        resultSet=preparedStatement.executeQuery();

        while(resultSet.next()){
            int iid = resultSet.getInt("iid");
            String interest = resultSet.getString("interest");

            InterestBean interestBean = new InterestBean();
            interestBean.setInterest(interest);
            interestBean.setUid(uid);
            interestBean.setIid(iid);

            interestBeanList.add(interestBean);

        }
        dbutil.closeDBResource(connection, preparedStatement, resultSet);
        return interestBeanList;
    }
}

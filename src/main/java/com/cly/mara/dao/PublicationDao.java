package com.cly.mara.dao;

import com.cly.mara.bean.PublicationBean;

import java.util.List;

public interface PublicationDao {
    List<PublicationBean> fetchPublicationList()throws Exception;
    List<PublicationBean> fetchPublicationList(int year)throws Exception;
    PublicationBean fetchPublication(int pid)throws Exception;
    boolean addAPublication(PublicationBean article);
    boolean updatePublication(PublicationBean article);

}

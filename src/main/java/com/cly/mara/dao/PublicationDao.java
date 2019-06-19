package com.cly.mara.dao;

import com.cly.mara.bean.PulicationBean;

import java.util.List;

public interface PublicationDao {
    List<PulicationBean> fetchPublicationList()throws Exception;
    List<PulicationBean> fetchPublicationList(int year)throws Exception;
    PulicationBean fetchPublication(int aid)throws Exception;
    boolean addAPublication(PulicationBean article);
    boolean updatePublication(PulicationBean article);

}

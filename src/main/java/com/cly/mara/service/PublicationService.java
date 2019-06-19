package com.cly.mara.service;

import com.cly.mara.bean.PublicationBean;

import java.util.List;

public interface PublicationService {
    List<PublicationBean> getPublicationList()throws Exception;
    List<PublicationBean> getPublicationList(int year)throws Exception;
    List<PublicationBean> getRecentPublicationList() throws Exception;
    PublicationBean getPublication(int pid)throws Exception;
    boolean addPublication(PublicationBean article);
    boolean updatePublication(PublicationBean article);
}

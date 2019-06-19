package com.cly.mara.service;

import com.cly.mara.bean.PulicationBean;

import java.util.List;

public interface PublicationService {
    List<PulicationBean> getPublicationList()throws Exception;
    List<PulicationBean> getPublicationList(int year)throws Exception;
    List<PulicationBean> getRecentPublicationList() throws Exception;
    PulicationBean getPublication(int aid)throws Exception;
    boolean addPublication(PulicationBean article);
    boolean updatePublication(PulicationBean article);
}

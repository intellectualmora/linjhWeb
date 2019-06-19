package com.cly.mara.service;

import com.cly.mara.bean.PublicationBean;
import com.cly.mara.dao.PublicationDao;
import com.cly.mara.dao.PublicationDaoImpl;

import java.util.List;

public class PublicationServiceImpl implements PublicationService {
    PublicationDao publicationDao = new PublicationDaoImpl();
    @Override
    public List<PublicationBean> getPublicationList() throws Exception {
        return publicationDao.fetchPublicationList();
    }

    @Override
    public List<PublicationBean> getPublicationList(int year) throws Exception {
        return publicationDao.fetchPublicationList(year);
    }

    @Override
    public List<PublicationBean> getRecentPublicationList() throws Exception {
        List<PublicationBean> publicationBeanList = publicationDao.fetchPublicationList();
        if (publicationBeanList.size()>5){
            publicationBeanList = publicationBeanList.subList(0,5);
        }
        return publicationBeanList;
    }

    @Override
    public PublicationBean getPublication(int pid) throws Exception {
        return publicationDao.fetchPublication(pid);
    }

    @Override
    public boolean addPublication(PublicationBean article) {
        return false;
    }

    @Override
    public boolean updatePublication(PublicationBean article) {
        return false;
    }
}

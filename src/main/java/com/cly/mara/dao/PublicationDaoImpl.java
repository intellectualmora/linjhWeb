package com.cly.mara.dao;

import com.cly.mara.bean.PulicationBean;

import java.util.List;

public class PublicationDaoImpl implements PublicationDao {

    @Override
    public List<PulicationBean> fetchPublicationList() throws Exception {
        return null;
    }

    @Override
    public List<PulicationBean> fetchPublicationList(int year) throws Exception {
        return null;
    }

    @Override
    public PulicationBean fetchPublication(int aid) throws Exception {
        return null;
    }

    @Override
    public boolean addAPublication(PulicationBean article) {
        return false;
    }

    @Override
    public boolean updatePublication(PulicationBean article) {
        return false;
    }
}

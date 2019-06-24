package com.cly.mara.service;

import com.cly.mara.bean.AlumniBean;
import com.cly.mara.dao.AluminDao;
import com.cly.mara.dao.AlumniDaoImpl;

import java.util.List;

public class AlumniServiceImpl implements AlumniService {
    AluminDao aluminDao = new AlumniDaoImpl();
    @Override
    public List<AlumniBean> getAlumniBeanList() throws Exception {
        return aluminDao.fetchAlumniBeanList();
    }
}

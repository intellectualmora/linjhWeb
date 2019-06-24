package com.cly.mara.dao;

import com.cly.mara.bean.AlumniBean;

import java.util.List;

public interface AluminDao {
    public List<AlumniBean> fetchAlumniBeanList() throws Exception;
}

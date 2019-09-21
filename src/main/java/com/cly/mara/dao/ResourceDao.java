package com.cly.mara.dao;

import com.cly.mara.bean.ResourceBean;

import java.util.List;

public interface ResourceDao {
    List<ResourceBean> fetchResourceBeanList() throws Exception;
}

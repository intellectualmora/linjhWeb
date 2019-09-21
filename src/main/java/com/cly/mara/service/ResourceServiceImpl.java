package com.cly.mara.service;

import com.cly.mara.bean.ResourceBean;
import com.cly.mara.dao.ResourceDao;
import com.cly.mara.dao.ResourceDaoImpl;

import java.util.List;

public class ResourceServiceImpl implements ResourceService {
    ResourceDao resourceDao = new ResourceDaoImpl();

    @Override
    public List<ResourceBean> getResourceBeanList() throws Exception {
        return resourceDao.fetchResourceBeanList();
    }
}

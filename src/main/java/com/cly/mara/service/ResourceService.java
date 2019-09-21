package com.cly.mara.service;

import com.cly.mara.bean.ResourceBean;

import java.util.List;

public interface ResourceService {
    List<ResourceBean> getResourceBeanList() throws Exception;
}

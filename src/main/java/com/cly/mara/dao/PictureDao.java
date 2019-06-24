package com.cly.mara.dao;

import com.cly.mara.bean.PictureBean;

import java.util.List;

public interface PictureDao {
    List<PictureBean> fetchAlbumList() throws Exception;
    List<PictureBean> fetchPictureBeanList(int year) throws Exception;
}

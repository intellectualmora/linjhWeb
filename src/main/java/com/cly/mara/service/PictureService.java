package com.cly.mara.service;


import com.cly.mara.bean.PictureBean;

import java.util.List;

public interface PictureService {
    List<PictureBean> getPictureBeanList(int year)throws Exception;
    List<PictureBean> getAlbumList() throws Exception;
    boolean addPicture(PictureBean pictureBean);
    boolean updatePicture(PictureBean pictureBean);
}

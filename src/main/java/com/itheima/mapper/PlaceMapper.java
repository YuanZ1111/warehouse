package com.itheima.mapper;

import com.itheima.entity.Place;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 85839
* @description 针对表【place(产地)】的数据库操作Mapper
* @createDate 2023-07-25 10:33:59
* @Entity com.itheima.entity.Place
*/
@Mapper
public interface PlaceMapper {

    //查询所有产地

    public List<Place> findAllPlace();

}





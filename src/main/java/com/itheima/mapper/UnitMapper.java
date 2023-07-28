package com.itheima.mapper;

import com.itheima.entity.Unit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 85839
* @description 针对表【unit(规格单位表)】的数据库操作Mapper
* @createDate 2023-07-25 10:33:48
* @Entity com.itheima.entity.Unit
*/
@Mapper
public interface UnitMapper {

    public List<Unit> getUnitList();

}





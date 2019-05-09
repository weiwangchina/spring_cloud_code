package cn.wcuu.product_service.mapper;

import org.apache.ibatis.annotations.Select;

public interface BaseRegionMapper {

    @Select("select id,'name', type, alias from store_base_region where id = #{parentId}")
    java.util.Map selectOne(java.util.Map<String, Object> params);

}

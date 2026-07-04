package com.ruoyi.hospital.mapper;

import com.ruoyi.common.core.mapper.BaseMapper;
import com.ruoyi.hospital.domain.po.RyHospital;
import com.ruoyi.hospital.domain.query.RyHospitalQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 医院 Mapper
 *
 * @author YiJiawei
 * @date 2026/7/2
 */
@Mapper
public interface RyHospitalMapper extends BaseMapper<RyHospital, String>
{
    /**
     * 分页条件查询医院列表
     *
     * @param query 查询条件
     * @return java.util.List<com.ruoyi.hospital.domain.po.RyHospital>
     * @author YiJiawei
     * @date 2026/7/2
     **/
    List<RyHospital> selectHospitalList(RyHospitalQuery query);
}

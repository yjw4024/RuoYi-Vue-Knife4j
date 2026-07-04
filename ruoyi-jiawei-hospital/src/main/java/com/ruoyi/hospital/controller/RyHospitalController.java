package com.ruoyi.hospital.controller;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.BeanConvertUtils;
import com.ruoyi.hospital.domain.dto.RyHospitalDTO;
import com.ruoyi.hospital.domain.po.RyHospital;
import com.ruoyi.hospital.domain.query.RyHospitalQuery;
import com.ruoyi.hospital.domain.vo.RyHospitalVO;
import com.ruoyi.hospital.service.IRyHospitalService;

/**
 * 医院 Controller
 *
 * @author YiJiawei
 * @date 2026/7/2
 */
@Tag(name = "医院管理")
@RestController
@RequestMapping("/hospital")
public class RyHospitalController extends BaseController
{
    @Autowired
    private IRyHospitalService hospitalService;

    /**
     * 获取医院列表
     *
     * @param query 查询条件
     * @return com.ruoyi.common.core.page.TableDataInfo
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Operation(summary = "获取医院列表")
    @GetMapping("/list")
    public TableDataInfo list(RyHospitalQuery query)
    {
        startPage();
        RyHospital search = BeanConvertUtils.convert(query, RyHospital.class);
        List<RyHospital> list = hospitalService.selectList(search);
        return getDataTable(BeanConvertUtils.convertList(list, RyHospitalVO.class));
    }

    /**
     * 获取医院详情
     *
     * @param id 医院ID
     * @return com.ruoyi.common.core.domain.AjaxResult
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Operation(summary = "获取医院详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable String id)
    {
        return success(BeanConvertUtils.convert(hospitalService.selectById(id), RyHospitalVO.class));
    }

    /**
     * 新增医院
     *
     * @param dto 医院信息
     * @return com.ruoyi.common.core.domain.AjaxResult
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Operation(summary = "新增医院")
    @PostMapping
    public AjaxResult add(@Valid @RequestBody RyHospitalDTO dto)
    {
        RyHospital po = BeanConvertUtils.convert(dto, RyHospital.class);
        po.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        return toAjax(hospitalService.insert(po));
    }

    /**
     * 修改医院
     *
     * @param dto 医院信息
     * @return com.ruoyi.common.core.domain.AjaxResult
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Operation(summary = "修改医院")
    @PutMapping
    public AjaxResult edit(@Valid @RequestBody RyHospitalDTO dto)
    {
        RyHospital po = BeanConvertUtils.convert(dto, RyHospital.class);
        return toAjax(hospitalService.updateById(po));
    }

    /**
     * 删除医院
     *
     * @param id 医院ID
     * @return com.ruoyi.common.core.domain.AjaxResult
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Operation(summary = "删除医院")
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable String id)
    {
        return toAjax(hospitalService.deleteById(id));
    }
}

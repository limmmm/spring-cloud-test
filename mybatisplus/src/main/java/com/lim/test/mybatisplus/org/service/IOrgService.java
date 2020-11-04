package com.lim.test.mybatisplus.org.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lim.test.mybatisplus.org.model.dto.OrgSaveDto;
import com.lim.test.mybatisplus.org.model.entity.Org;

import java.util.List;

/**
 * @author lim
 * @since 2020/2/17
 */
public interface IOrgService extends IService<Org> {

    /**
     * 查询所有机构
     * @return List<User>
     */
    List<Org> listAll();

    /**
     * 新增机构
     * @param org 机构信息
     * @return 影响的记录条数
     */
    Integer insert(OrgSaveDto org);

    /**
     * 删除机构
     * @param id 机构id
     * @return 影响的记录条数
     */
    Integer delete(Long id);
}

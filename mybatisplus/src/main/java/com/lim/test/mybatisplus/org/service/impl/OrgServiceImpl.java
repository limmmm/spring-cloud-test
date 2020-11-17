package com.lim.test.mybatisplus.org.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lim.test.mybatisplus.org.mapper.OrgMapper;
import com.lim.test.mybatisplus.org.model.dto.OrgSaveDto;
import com.lim.test.mybatisplus.org.model.entity.Org;
import com.lim.test.mybatisplus.org.service.IOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lim
 * @since 2020/2/17
 */
@Service
@Primary
@Slf4j
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {


    @Override
    public List<Org> listAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public Integer insert(OrgSaveDto orgSaveDto) {
        Org org = new Org();
        BeanUtils.copyProperties(orgSaveDto, org);
        return baseMapper.insert(org);
    }

    @Override
    public Integer delete(Long id) {
        return baseMapper.deleteById(id);
    }
}

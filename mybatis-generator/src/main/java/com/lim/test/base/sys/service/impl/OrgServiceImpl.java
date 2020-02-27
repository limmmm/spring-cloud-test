package com.lim.test.base.sys.service.impl;

import com.lim.test.base.sys.entity.Org;
import com.lim.test.base.sys.mapper.OrgMapper;
import com.lim.test.base.sys.service.IOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lim
 * @since 2020-02-27
 */
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {

}

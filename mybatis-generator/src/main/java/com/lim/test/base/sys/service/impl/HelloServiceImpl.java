package com.lim.test.base.sys.service.impl;

import com.lim.test.base.sys.entity.Hello;
import com.lim.test.base.sys.mapper.HelloMapper;
import com.lim.test.base.sys.service.IHelloService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lim
 * @since 2020-03-01
 */
@Service
public class HelloServiceImpl extends ServiceImpl<HelloMapper, Hello> implements IHelloService {

}

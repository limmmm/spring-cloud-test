package com.lim.test.mybatisplus.org.controller;

import com.lim.test.mybatisplus.org.model.dto.OrgSaveDto;
import com.lim.test.mybatisplus.org.model.entity.Org;
import com.lim.test.mybatisplus.org.service.IOrgService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 机构
 * @author Lim
 * @date 2020/2/17
 */
@RestController
@RequestMapping("/org")
public class OrgController {

    private final IOrgService orgService;

    public OrgController(IOrgService orgService) {
        this.orgService = orgService;
    }

    /**
     * 查询所有
     * @return List<User>
     */
    @GetMapping("/list")
    public List<Org> list() {
        return orgService.listAll();
    }

    /**
     * 新增
     * @param orgSaveDto 机构信息
     * @return 影响的记录条数
     */
    @PostMapping
    public Integer insert(@RequestBody OrgSaveDto orgSaveDto) {
        return orgService.insert(orgSaveDto);
    }

    /**
     * 删除
     * @param id 机构id
     * @return 影响的记录条数
     */
    @DeleteMapping
    public Integer del(Long id) {
        return orgService.delete(id);
    }

}

package com.newtong.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newtong.shortlink.admin.common.biz.user.UserContext;
import com.newtong.shortlink.admin.dao.entity.GroupDO;
import com.newtong.shortlink.admin.dto.resp.GroupRespDO;
import com.newtong.shortlink.admin.service.GroupDOService;
import com.newtong.shortlink.admin.dao.mapper.GroupDOMapper;
import com.newtong.shortlink.admin.toolkit.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hp
 * @description 针对表【t_group】的数据库操作Service实现
 * @createDate 2024-08-01 17:41:08
 */
@Slf4j
@Service
public class GroupDOServiceImpl extends ServiceImpl<GroupDOMapper, GroupDO>
        implements GroupDOService {

    @Override
    public void saveGroup(String groupName) {
        String gid;
        do {
            gid = RandomGenerator.generateGroupId();
        } while (hasGid(gid));
        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .sortOrder(0)
                .username(UserContext.getUsername())
                .groupName(groupName)
                .build();
        baseMapper.insert(groupDO);
    }

    @Override
    public List<GroupRespDO> getAllGroup() {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .orderByDesc(List.of(GroupDO::getSortOrder, GroupDO::getUpdateTime));
        List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);
        return BeanUtil.copyToList(groupDOList, GroupRespDO.class);
    }

    private boolean hasGid(String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, UserContext.getUsername());
        return baseMapper.selectOne(queryWrapper) != null;
    }
}





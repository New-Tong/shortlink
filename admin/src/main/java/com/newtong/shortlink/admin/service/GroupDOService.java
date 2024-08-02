package com.newtong.shortlink.admin.service;

import com.newtong.shortlink.admin.dao.entity.GroupDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.newtong.shortlink.admin.dto.req.GroupUpdateReqDTO;
import com.newtong.shortlink.admin.dto.resp.GroupRespDO;

import java.util.List;

/**
* @author hp
* @description 针对表【t_group】的数据库操作Service
* @createDate 2024-08-01 17:41:08
*/
public interface GroupDOService extends IService<GroupDO> {

    /**
     * @Author NewTong
     * @Date 10:06 2024/8/2
     * @Description 新增短链接分组
     */
    void saveGroup(String groupName);

    /**
     * @Author NewTong
     * @Date 10:07 2024/8/2
     * @Description 获取登录用户所有短链接分组
     */
    List<GroupRespDO> getAllGroup();

    /**
     * @Author NewTong
     * @Date 10:07 2024/8/2
     * @Description 修改短链接分组
     */
    void updateGroup(GroupUpdateReqDTO requestParam);

    void deleteGroup(String gid);
}

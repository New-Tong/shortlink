package com.newtong.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newtong.shortlink.admin.dao.entity.UserDO;
import com.newtong.shortlink.admin.dto.resp.UserRespDTO;

/**
* @author hp
* @description 针对表【t_user】的数据库操作Service
* @createDate 2024-07-29 17:43:17
*/
public interface UserDOService extends IService<UserDO> {
    UserRespDTO getUserByUsername(String username);
}

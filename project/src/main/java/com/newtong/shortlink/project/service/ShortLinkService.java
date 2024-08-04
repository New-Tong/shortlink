package com.newtong.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.newtong.shortlink.project.dao.entity.LinkDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.newtong.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.newtong.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.newtong.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.newtong.shortlink.project.dto.resp.ShortLinkPageRespDTO;

/**
* @author NewTong
* @description 针对表【t_link】的数据库操作Service
* @createDate 2024-08-03 13:18:47
*/
public interface ShortLinkService extends IService<LinkDO> {

    /**
     * @Author NewTong
     * @Date 14:02 2024/8/3
     * @Description 创建短链接
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);

    IPage<ShortLinkPageRespDTO> getShortLinkPage(ShortLinkPageReqDTO requestParam);
}

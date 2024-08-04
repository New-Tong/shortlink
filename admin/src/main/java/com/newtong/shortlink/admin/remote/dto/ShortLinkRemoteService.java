package com.newtong.shortlink.admin.remote.dto;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.newtong.shortlink.admin.common.convention.result.Result;
import com.newtong.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import com.newtong.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import com.newtong.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import com.newtong.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NewTong
 * @Date 2024/8/4 -14:50
 * @Description
 */
public interface ShortLinkRemoteService {

    /**
     * @Author NewTong
     * @Date 15:20 2024/8/4
     * @Description 获取短链接分页
     */
    default Result<IPage<ShortLinkPageRespDTO>> getShortLinkPage(ShortLinkPageReqDTO requestParam) {
        Map<String, Object> map = new HashMap<>();
        map.put("gid", requestParam.getGid());
        map.put("current", requestParam.getCurrent());
        map.put("size", requestParam.getSize());
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/page", map);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }

    /**
     * @Author NewTong
     * @Date 15:20 2024/8/4
     * @Description 创建短链接
     */
    default Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam) {
        return JSON.parseObject(HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/create", JSON.toJSONString(requestParam)), new TypeReference<>() {
        });
    }
}

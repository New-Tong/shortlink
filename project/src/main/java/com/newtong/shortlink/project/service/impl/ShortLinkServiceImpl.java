package com.newtong.shortlink.project.service.impl;

import cn.hutool.core.text.StrBuilder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newtong.shortlink.project.common.convention.exception.ServiceException;
import com.newtong.shortlink.project.dao.entity.LinkDO;
import com.newtong.shortlink.project.dao.mapper.LinkDOMapper;
import com.newtong.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.newtong.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.newtong.shortlink.project.service.ShortLinkService;
import com.newtong.shortlink.project.toolkit.HashUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBloomFilter;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
* @author NewTong
* @description 针对表【t_link】的数据库操作Service实现
* @createDate 2024-08-03 13:18:47
*/
@Service
@Slf4j
@RequiredArgsConstructor
public class ShortLinkServiceImpl extends ServiceImpl<LinkDOMapper, LinkDO>
    implements ShortLinkService {

    private final RBloomFilter<String> bloomFilter;

    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam) {
        // 1. 创建短链接
        String shortUri = generateShortUri(requestParam);
        String fullShortUrl = StrBuilder.create(requestParam.getDomain())
                .append("/")
                .append(shortUri)
                .toString();
        LinkDO linkDO = LinkDO.builder()
                .domain(requestParam.getDomain())
                .shortUri(shortUri)
                .fullShortUrl(fullShortUrl)
                .originUrl(requestParam.getOriginUrl())
                .gid(requestParam.getGid())
                .createdType(requestParam.getCreatedType())
                .validDateType(requestParam.getValidDateType())
                .validDate(requestParam.getValidDate())
                .description(requestParam.getDescription())
                .build();
        try {
            baseMapper.insert(linkDO);
        } catch (DuplicateKeyException e) {
            LambdaQueryWrapper<LinkDO> queryWrapper = Wrappers.lambdaQuery(LinkDO.class).eq(LinkDO::getFullShortUrl, fullShortUrl);
            LinkDO queryLinkDO = baseMapper.selectOne(queryWrapper);
            if (queryLinkDO != null) {
                log.warn("短链接：{}重复入库", fullShortUrl);
                throw new ServiceException("短链接生成重复");
            }
        }
        bloomFilter.add(shortUri);
        // 2. 返回短链接
        return ShortLinkCreateRespDTO.builder()
                .gid(requestParam.getGid())
                .shortUri(shortUri)
                .fullShortUrl(fullShortUrl)
                .originUrl(requestParam.getOriginUrl())
                .build();
    }

    private String generateShortUri(ShortLinkCreateReqDTO requestParam) {
        int customGenerateCount = 0;
        while (true) {
            if (customGenerateCount > 10) {
                throw new ServiceException("短链接生成频繁，请稍后再试");
            }
            String originUrl = requestParam.getOriginUrl() + System.currentTimeMillis();
            String shortLinkUri = HashUtil.hashToBase62(originUrl);
            if (bloomFilter.contains(shortLinkUri)) {
                customGenerateCount++;
                continue;
            }
            return shortLinkUri;
        }
    }
}

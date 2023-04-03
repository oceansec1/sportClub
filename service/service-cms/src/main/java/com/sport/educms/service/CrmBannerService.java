package com.sport.educms.service;

import com.sport.educms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-30
 */
public interface CrmBannerService extends IService<CrmBanner> {
List<CrmBanner> selectAllBanner();
}

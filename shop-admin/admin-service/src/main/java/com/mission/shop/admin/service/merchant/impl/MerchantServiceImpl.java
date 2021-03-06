package com.mission.shop.admin.service.merchant.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission.shop.admin.dao.entity.merchant.MerchantEntity;
import com.mission.shop.admin.dao.mapper.merchant.IMerchantMapper;
import com.mission.shop.admin.exception.ServiceException;
import com.mission.shop.admin.service.merchant.IMerchantService;
import com.mission.shop.admin.utils.log.JscnLogger;
import com.mission.shop.admin.utils.page.Pagination;
import com.mission.shop.admin.utils.persistent.QueryCondition;
import com.mission.shop.admin.utils.persistent.ResultList;
import com.mission.shop.admin.utils.persistent.ResultListImpl;
import com.mission.shop.base.common.utils.StringUtils;

@Service(value = IMerchantService.SERVICE_NAME)
public class MerchantServiceImpl implements IMerchantService {

	@Autowired
	private IMerchantMapper merchantMapper;
	@Override
	public MerchantEntity getMerchant(String id) throws ServiceException {
		try {
			QueryCondition condition = new QueryCondition();
			condition.addAllColumn(MerchantEntity.class);
			condition.addCondition("id", id);
			return merchantMapper.getMerchant(condition);
		} catch (Exception e) {
			JscnLogger.error("获得商户信息错误", e, this.getClass());
			throw new ServiceException("获得商户信息错误", e);
		}
	}

	@Override
	public void addMerchant(MerchantEntity entity) throws ServiceException {
		try {
			merchantMapper.insertMerchant(entity);
		} catch (Exception e) {
			JscnLogger.error("新增商户信息错误", e, this.getClass());
			throw new ServiceException("新增商户信息错误", e);
		}
	}

	@Override
	public void updateMerchant(MerchantEntity entity) throws ServiceException {
		try {
			merchantMapper.updateMerchant(entity);
		} catch (Exception e) {
			JscnLogger.error("更新商户信息错误", e, this.getClass());
			throw new ServiceException("更新商户信息错误", e);
		}
	}

	@Override
	public void deleteMerchant(String id) throws ServiceException {
		try {
			merchantMapper.deleteMerchant(id);
		} catch (Exception e) {
			JscnLogger.error("删除商户信息错误", e, this.getClass());
			throw new ServiceException("删除商户信息错误", e);
		}
	}

	@Override
	public ResultList<MerchantEntity> queryMerchant(String is_lock,String merchant_type_name,String name,Pagination page, Set<String> columns)
			throws ServiceException {
		try {
			QueryCondition condition = new QueryCondition();
			if (columns != null && columns.size() > 0) {
				condition.setColumns(columns);
			} else {
				condition.addAllColumn(MerchantEntity.class);
			}
			if (StringUtils.isNotEmpty(is_lock)) {
				condition.addCondition("is_lock", is_lock);
			}
			if (StringUtils.isNotEmpty(merchant_type_name)) {
				condition.addCondition("merchant_type_name", merchant_type_name);
			}
			if (StringUtils.isNotEmpty(name)) {
				condition.addCondition("name", name);
			}
			if (page != null) {
				Long totalCount = merchantMapper.countMerchant(condition);
				page.setTotalCount(totalCount.intValue());
				condition.addCondition("minnum", page.getStartNo());
				condition.addCondition("maxnum", page.getEndNo());
			}
			List<MerchantEntity> list = merchantMapper.queryMerchant(condition);
			ResultList<MerchantEntity> res = new ResultListImpl<MerchantEntity>();
			res.setResults(list);
			res.setPage(page);
			return res;
		} catch (Exception e) {
			JscnLogger.error("查询商户信息错误", e, this.getClass());
			throw new ServiceException("查询商户信息错误", e);
		}
	}
}

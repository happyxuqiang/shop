package com.mission.shop.order.dao.mapper;

import com.mission.shop.order.dao.model.Express;
import com.mission.shop.order.dao.model.ExpressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpressMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	int countByExample(ExpressExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	int deleteByExample(ExpressExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	int deleteByPrimaryKey(Long expressId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	int insert(Express record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	int insertSelective(Express record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	List<Express> selectByExample(ExpressExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	Express selectByPrimaryKey(Long expressId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	int updateByExampleSelective(@Param("record") Express record,
			@Param("example") ExpressExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	int updateByExample(@Param("record") Express record,
			@Param("example") ExpressExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	int updateByPrimaryKeySelective(Express record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table express
	 * @mbggenerated  Wed Aug 06 21:14:03 CST 2014
	 */
	int updateByPrimaryKey(Express record);
}
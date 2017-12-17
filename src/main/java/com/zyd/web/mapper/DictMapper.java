package com.zyd.web.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.zyd.web.model.SysDict;

public interface DictMapper {
	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	SysDict selectByPrimaryKey(Long id);

	/**
	 * 条件查询
	 * 
	 * @param sysDict
	 * @param rowBounds
	 * @return
	 */
	List<SysDict> selectBySysDict(SysDict sysDict, RowBounds rowBounds);

	/**
	 * 新增
	 * 
	 * @param sysDict
	 * @return
	 */
	int insert(SysDict sysDict);

	/**
	 * 根据主键更新
	 * 
	 * @param sysDict
	 * @return
	 */
	int updateById(SysDict sysDict);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Long id);
}

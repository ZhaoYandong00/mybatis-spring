package com.zyd.web.service;

import java.util.List;

import com.zyd.web.model.SysDict;

public interface DictService {
	/**
	 * 使用id查找
	 * 
	 * @param id
	 * @return
	 */
	SysDict findById(Long id);

	/**
	 * 条件查询
	 * 
	 * @param sysDict
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<SysDict> findBySysDict(SysDict sysDict, Integer offset, Integer limit);

	/**
	 * 插入和更新
	 * 
	 * @param sysDict
	 * @return
	 */
	boolean saveOrUpdate(SysDict sysDict);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteById(Long id);
}

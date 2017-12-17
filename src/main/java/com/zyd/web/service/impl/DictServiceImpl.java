package com.zyd.web.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyd.web.mapper.DictMapper;
import com.zyd.web.model.SysDict;
import com.zyd.web.service.DictService;

@Service
public class DictServiceImpl implements DictService {
	@Autowired
	private DictMapper dictMapper;

	@Override
	public SysDict findById(Long id) {
		return dictMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<SysDict> findBySysDict(SysDict sysDict, Integer offset, Integer limit) {
		RowBounds rowBounds = RowBounds.DEFAULT;
		if (offset != null && limit != null) {
			rowBounds = new RowBounds(offset, limit);
		}
		return dictMapper.selectBySysDict(sysDict, rowBounds);
	}

	@Override
	public boolean saveOrUpdate(SysDict sysDict) {
		if (sysDict.getId() == null) {
			return dictMapper.insert(sysDict) == 1;
		} else {
			return dictMapper.updateById(sysDict) == 1;
		}
	}

	@Override
	public boolean deleteById(Long id) {
		return dictMapper.deleteById(id) == 1;
	}

}

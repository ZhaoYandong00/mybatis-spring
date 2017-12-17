package com.zyd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyd.web.model.SysDict;
import com.zyd.web.service.DictService;

@Controller
@RequestMapping("/dicts")
public class DictController {
	@Autowired
	private DictService dictService;

	/**
	 * 显示字典数据列表
	 * 
	 * @param sysDict
	 * @param offset
	 * @param limit
	 * @return
	 */
	@RequestMapping
	public ModelAndView dicts(SysDict sysDict, Integer offset, Integer limit) {

		// RequestMapping 表示采用类 RequestMapping的value ，即在网站输入/dicts就采用此方法返回值
		// "dicts"根据 mybatis-servlet.xml 的设置会自动找到dicts.jsp
		ModelAndView mv = new ModelAndView("dicts");
		//获取所有字典值
		List<SysDict> dicts = dictService.findBySysDict(sysDict, offset, limit);
		//把字典值给ModelAndView的dicts
		mv.addObject("dicts", dicts);
		return mv;
	}

	/**
	 * 新增或修改字典信息页面，使用get跳转到页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add(Long id) {
		ModelAndView mv = new ModelAndView("dict_add");
		SysDict sysDict;
		if (id == null) {
			// 如果id不存在，就是新增数据，创建一个新对象
			sysDict = new SysDict();
		} else {
			// 如果id存在，就是修改数据，把原有的数据查询出来
			sysDict = dictService.findById(id);
		}
		mv.addObject("model", sysDict);
		return mv;
	}

	/**
	 * 新增或修改字典信息页面，通过表单提交数据
	 * 
	 * @param sysDict
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView save(SysDict sysDict) {
		ModelAndView mv = new ModelAndView();
		try {
			dictService.saveOrUpdate(sysDict);
			mv.setViewName("redirect:/dicts");
		} catch (Exception e) {
			mv.setViewName("dict_add");
			mv.addObject("msg", e.getMessage());
			mv.addObject("model", sysDict);
		}
		return mv;
	}

	/**
	 * 通过id删除字典信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap delete(@RequestParam Long id) {
		ModelMap modelMap = new ModelMap();
		try {
			boolean success = dictService.deleteById(id);
			modelMap.put("success", success);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("msg", e.getMessage());
		}
		return modelMap;
	}
}

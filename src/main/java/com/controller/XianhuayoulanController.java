package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XianhuayoulanEntity;
import com.entity.view.XianhuayoulanView;

import com.service.XianhuayoulanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 鲜花游览
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-20 11:33:20
 */
@RestController
@RequestMapping("/xianhuayoulan")
public class XianhuayoulanController {
    @Autowired
    private XianhuayoulanService xianhuayoulanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XianhuayoulanEntity xianhuayoulan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			xianhuayoulan.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XianhuayoulanEntity> ew = new EntityWrapper<XianhuayoulanEntity>();
		PageUtils page = xianhuayoulanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianhuayoulan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XianhuayoulanEntity xianhuayoulan, HttpServletRequest request){
        EntityWrapper<XianhuayoulanEntity> ew = new EntityWrapper<XianhuayoulanEntity>();
		PageUtils page = xianhuayoulanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianhuayoulan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XianhuayoulanEntity xianhuayoulan){
       	EntityWrapper<XianhuayoulanEntity> ew = new EntityWrapper<XianhuayoulanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xianhuayoulan, "xianhuayoulan")); 
        return R.ok().put("data", xianhuayoulanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XianhuayoulanEntity xianhuayoulan){
        EntityWrapper< XianhuayoulanEntity> ew = new EntityWrapper< XianhuayoulanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xianhuayoulan, "xianhuayoulan")); 
		XianhuayoulanView xianhuayoulanView =  xianhuayoulanService.selectView(ew);
		return R.ok("查询鲜花游览成功").put("data", xianhuayoulanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XianhuayoulanEntity xianhuayoulan = xianhuayoulanService.selectById(id);
		xianhuayoulan.setClicknum(xianhuayoulan.getClicknum()+1);
		xianhuayoulan.setClicktime(new Date());
		xianhuayoulanService.updateById(xianhuayoulan);
        return R.ok().put("data", xianhuayoulan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XianhuayoulanEntity xianhuayoulan = xianhuayoulanService.selectById(id);
		xianhuayoulan.setClicknum(xianhuayoulan.getClicknum()+1);
		xianhuayoulan.setClicktime(new Date());
		xianhuayoulanService.updateById(xianhuayoulan);
        return R.ok().put("data", xianhuayoulan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XianhuayoulanEntity xianhuayoulan, HttpServletRequest request){
    	xianhuayoulan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianhuayoulan);

        xianhuayoulanService.insert(xianhuayoulan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XianhuayoulanEntity xianhuayoulan, HttpServletRequest request){
    	xianhuayoulan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianhuayoulan);

        xianhuayoulanService.insert(xianhuayoulan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XianhuayoulanEntity xianhuayoulan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xianhuayoulan);
        xianhuayoulanService.updateById(xianhuayoulan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xianhuayoulanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XianhuayoulanEntity> wrapper = new EntityWrapper<XianhuayoulanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			wrapper.eq("shangjiazhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = xianhuayoulanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XianhuayoulanEntity xianhuayoulan, HttpServletRequest request,String pre){
        EntityWrapper<XianhuayoulanEntity> ew = new EntityWrapper<XianhuayoulanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = xianhuayoulanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianhuayoulan), params), params));
        return R.ok().put("data", page);
    }


}

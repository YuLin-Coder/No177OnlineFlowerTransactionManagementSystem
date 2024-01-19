package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.XianhuayoulanDao;
import com.entity.XianhuayoulanEntity;
import com.service.XianhuayoulanService;
import com.entity.vo.XianhuayoulanVO;
import com.entity.view.XianhuayoulanView;

@Service("xianhuayoulanService")
public class XianhuayoulanServiceImpl extends ServiceImpl<XianhuayoulanDao, XianhuayoulanEntity> implements XianhuayoulanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianhuayoulanEntity> page = this.selectPage(
                new Query<XianhuayoulanEntity>(params).getPage(),
                new EntityWrapper<XianhuayoulanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianhuayoulanEntity> wrapper) {
		  Page<XianhuayoulanView> page =new Query<XianhuayoulanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XianhuayoulanVO> selectListVO(Wrapper<XianhuayoulanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XianhuayoulanVO selectVO(Wrapper<XianhuayoulanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XianhuayoulanView> selectListView(Wrapper<XianhuayoulanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianhuayoulanView selectView(Wrapper<XianhuayoulanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

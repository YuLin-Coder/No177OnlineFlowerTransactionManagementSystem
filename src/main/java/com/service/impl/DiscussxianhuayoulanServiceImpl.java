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


import com.dao.DiscussxianhuayoulanDao;
import com.entity.DiscussxianhuayoulanEntity;
import com.service.DiscussxianhuayoulanService;
import com.entity.vo.DiscussxianhuayoulanVO;
import com.entity.view.DiscussxianhuayoulanView;

@Service("discussxianhuayoulanService")
public class DiscussxianhuayoulanServiceImpl extends ServiceImpl<DiscussxianhuayoulanDao, DiscussxianhuayoulanEntity> implements DiscussxianhuayoulanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxianhuayoulanEntity> page = this.selectPage(
                new Query<DiscussxianhuayoulanEntity>(params).getPage(),
                new EntityWrapper<DiscussxianhuayoulanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxianhuayoulanEntity> wrapper) {
		  Page<DiscussxianhuayoulanView> page =new Query<DiscussxianhuayoulanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxianhuayoulanVO> selectListVO(Wrapper<DiscussxianhuayoulanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxianhuayoulanVO selectVO(Wrapper<DiscussxianhuayoulanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxianhuayoulanView> selectListView(Wrapper<DiscussxianhuayoulanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxianhuayoulanView selectView(Wrapper<DiscussxianhuayoulanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

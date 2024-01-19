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


import com.dao.DiscussshangjiaDao;
import com.entity.DiscussshangjiaEntity;
import com.service.DiscussshangjiaService;
import com.entity.vo.DiscussshangjiaVO;
import com.entity.view.DiscussshangjiaView;

@Service("discussshangjiaService")
public class DiscussshangjiaServiceImpl extends ServiceImpl<DiscussshangjiaDao, DiscussshangjiaEntity> implements DiscussshangjiaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshangjiaEntity> page = this.selectPage(
                new Query<DiscussshangjiaEntity>(params).getPage(),
                new EntityWrapper<DiscussshangjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshangjiaEntity> wrapper) {
		  Page<DiscussshangjiaView> page =new Query<DiscussshangjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussshangjiaVO> selectListVO(Wrapper<DiscussshangjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshangjiaVO selectVO(Wrapper<DiscussshangjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshangjiaView> selectListView(Wrapper<DiscussshangjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshangjiaView selectView(Wrapper<DiscussshangjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

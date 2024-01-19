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


import com.dao.XianhuafenleiDao;
import com.entity.XianhuafenleiEntity;
import com.service.XianhuafenleiService;
import com.entity.vo.XianhuafenleiVO;
import com.entity.view.XianhuafenleiView;

@Service("xianhuafenleiService")
public class XianhuafenleiServiceImpl extends ServiceImpl<XianhuafenleiDao, XianhuafenleiEntity> implements XianhuafenleiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianhuafenleiEntity> page = this.selectPage(
                new Query<XianhuafenleiEntity>(params).getPage(),
                new EntityWrapper<XianhuafenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianhuafenleiEntity> wrapper) {
		  Page<XianhuafenleiView> page =new Query<XianhuafenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XianhuafenleiVO> selectListVO(Wrapper<XianhuafenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XianhuafenleiVO selectVO(Wrapper<XianhuafenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XianhuafenleiView> selectListView(Wrapper<XianhuafenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianhuafenleiView selectView(Wrapper<XianhuafenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

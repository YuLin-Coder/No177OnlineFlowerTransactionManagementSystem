package com.dao;

import com.entity.XianhuayoulanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XianhuayoulanVO;
import com.entity.view.XianhuayoulanView;


/**
 * 鲜花游览
 * 
 * @author 
 * @email 
 * @date 2021-03-20 11:33:20
 */
public interface XianhuayoulanDao extends BaseMapper<XianhuayoulanEntity> {
	
	List<XianhuayoulanVO> selectListVO(@Param("ew") Wrapper<XianhuayoulanEntity> wrapper);
	
	XianhuayoulanVO selectVO(@Param("ew") Wrapper<XianhuayoulanEntity> wrapper);
	
	List<XianhuayoulanView> selectListView(@Param("ew") Wrapper<XianhuayoulanEntity> wrapper);

	List<XianhuayoulanView> selectListView(Pagination page,@Param("ew") Wrapper<XianhuayoulanEntity> wrapper);
	
	XianhuayoulanView selectView(@Param("ew") Wrapper<XianhuayoulanEntity> wrapper);
	
}

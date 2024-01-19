package com.dao;

import com.entity.DiscussshangjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshangjiaVO;
import com.entity.view.DiscussshangjiaView;


/**
 * 商家评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-20 11:33:21
 */
public interface DiscussshangjiaDao extends BaseMapper<DiscussshangjiaEntity> {
	
	List<DiscussshangjiaVO> selectListVO(@Param("ew") Wrapper<DiscussshangjiaEntity> wrapper);
	
	DiscussshangjiaVO selectVO(@Param("ew") Wrapper<DiscussshangjiaEntity> wrapper);
	
	List<DiscussshangjiaView> selectListView(@Param("ew") Wrapper<DiscussshangjiaEntity> wrapper);

	List<DiscussshangjiaView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshangjiaEntity> wrapper);
	
	DiscussshangjiaView selectView(@Param("ew") Wrapper<DiscussshangjiaEntity> wrapper);
	
}

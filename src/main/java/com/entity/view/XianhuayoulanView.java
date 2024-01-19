package com.entity.view;

import com.entity.XianhuayoulanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 鲜花游览
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-20 11:33:20
 */
@TableName("xianhuayoulan")
public class XianhuayoulanView  extends XianhuayoulanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XianhuayoulanView(){
	}
 
 	public XianhuayoulanView(XianhuayoulanEntity xianhuayoulanEntity){
 	try {
			BeanUtils.copyProperties(this, xianhuayoulanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

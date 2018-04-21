package com.cennavi.dataplay.controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cennavi.dataplay.components.BasemapComp;
import com.cennavi.dataplay.model.ModelBase;
import com.cennavi.dataplay.model.ModelComp;

@RestController
@RequestMapping(value = "/studio")
public class StudioController {

	private static final Logger logger = LoggerFactory.getLogger(StudioController.class);
	
	@Autowired
	private BasemapComp basemapComp;

	@RequestMapping("/basemap-list")
	public List<ModelComp> basemapList(String name){
		
		try {
			return basemapComp.basemapList(name);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return new ArrayList<>();
		
	}
	
	
	@RequestMapping("/render-list")
	public List<ModelComp> renderList(String name){
		
		List<ModelComp> list = new ArrayList<>();
		
		return list;
		
	}
	
	
	@RequestMapping("/chart-list")
	public List<ModelComp> chartList(String name){
		
		List<ModelComp> list = new ArrayList<>();
		
		return list;
		
	}
	
	
	@RequestMapping("/div-style-list")
	public List<ModelComp> divStyleList(String name){
		
		List<ModelComp> list = new ArrayList<>();
		
		return list;
		
	}
	
	
	@RequestMapping("/basemap")
	public ModelBase basemap(String id){
		
		try {
			return basemapComp.basemap(id);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@RequestMapping("/render")
	public ModelBase render(int id){
		
		ModelBase model = null;
		
		return model;
		
	}
	
	@RequestMapping("/chart")
	public ModelBase chart(int id){
		
		ModelBase model = null;
		
		return model;
		
	}
	
	@RequestMapping("/release")
	public Object release(String content){
		
		
		return null;
	}
}

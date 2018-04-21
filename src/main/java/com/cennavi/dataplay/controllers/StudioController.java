package com.cennavi.dataplay.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cennavi.dataplay.model.ModelBase;
import com.cennavi.dataplay.model.ModelComp;

@RestController
@RequestMapping(value = "/studio")
public class StudioController {


	@RequestMapping("/basemap-list")
	public List<ModelComp> basemapList(String name){
		
		List<ModelComp> list = new ArrayList<>();
		
		return list;
		
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
	public ModelBase basemap(int id){
		
		ModelBase model = null;
		
		return model;
		
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

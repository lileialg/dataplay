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
import com.cennavi.dataplay.components.ChartComp;
import com.cennavi.dataplay.components.RenderComp;
import com.cennavi.dataplay.model.ModelBase;
import com.cennavi.dataplay.model.ModelChart;
import com.cennavi.dataplay.model.ModelComp;
import com.cennavi.dataplay.model.ModelRender;

@RestController
@RequestMapping(value = "/studio")
public class StudioController {

	private static final Logger logger = LoggerFactory.getLogger(StudioController.class);
	
	@Autowired
	private BasemapComp basemapComp;
	
	@Autowired
	private RenderComp renderComp;
	
	@Autowired
	private ChartComp chartComp;

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
		
		try {
			return renderComp.renderList(name);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return new ArrayList<>();
		
	}
	
	
	@RequestMapping("/chart-list")
	public List<ModelComp> chartList(String name){
		
		try {
			return chartComp.chartList(name);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return new ArrayList<>();
		
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
	public ModelRender render(String id){
		
		try {
			return renderComp.renderMap(id);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@RequestMapping("/chart")
	public ModelChart chart(String id){
		
		try {
			return chartComp.chart(id);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@RequestMapping("/release")
	public Object release(String content){
		
		
		return null;
	}
}

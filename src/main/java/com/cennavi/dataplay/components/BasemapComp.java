package com.cennavi.dataplay.components;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cennavi.dataplay.model.ModelBase;
import com.cennavi.dataplay.model.ModelComp;

@Component
public class BasemapComp {

	@Value("${basemap.init.path}")
	private String path;
	
	@Value("${basemap.image.url.prefix}")
	private String imagePrefixUrl;

	private Map<String, Map<String, String>> basemapInfo = new HashMap<>();
	
	private void init() throws FileNotFoundException{
		

		if (basemapInfo.size() == 0) {

			Scanner scanner = new Scanner(new FileInputStream(path));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				

				String[] splits = line.split(",");
				String mapName = splits[0];
				System.out.println(mapName+"-----"+splits.length);
				
				
				String solution = splits[1];
				String token = splits[2];
				String center = splits[3];
				String zoom = splits[4];
				String bearing = splits[5];
				String pitch = splits[6];

				Map<String, String> map = new HashMap<>();
				map.put("name", mapName);
				map.put("solution", solution);
				map.put("token", token);
				
				map.put("center", center);
				map.put("zoom", zoom);
				map.put("bearing", bearing);
				map.put("pitch", pitch);

				basemapInfo.put(solution, map);
			}

			scanner.close();

		}
	}

	public List<ModelComp> basemapList(String name)
			throws FileNotFoundException {

		init();

		List<ModelComp> list = new ArrayList<>();

		Set<Map.Entry<String, Map<String, String>>> set = basemapInfo
				.entrySet();

		if (name != null && name.length() > 0) {

			for (Map.Entry<String, Map<String, String>> en : set) {

				if (en.getValue().get("name").indexOf(name) >= 0) {

					ModelComp model = new ModelComp();

					model.setId(en.getKey());

					model.setName(en.getValue().get("name"));

					model.setImageUrl(imagePrefixUrl+en.getKey() + ".png");
					
					list.add(model);
				}
			}
		} else {

			for (Map.Entry<String, Map<String, String>> en : set) {

				ModelComp model = new ModelComp();

				model.setId(en.getKey());

				model.setName(en.getValue().get("name"));

				model.setImageUrl(imagePrefixUrl+en.getKey() + ".png");
				
				list.add(model);
			}
		}

		return list;

	}
	
	public ModelBase basemap(String id) throws FileNotFoundException{
		
		init();
		
		ModelBase model = new ModelBase();
		
		Map<String,String> map = basemapInfo.get(id);
		
		model.setId(id);
		model.setName(map.get("name"));
		model.setToken(map.get("token"));
		
		double[] center = new double[2];
		String[] cs = map.get("center").split("\\|");
		center[0] = Double.parseDouble(cs[0]);
		center[1] = Double.parseDouble(cs[1]);
		model.setCenter(center);
		
		model.setZoom(Double.parseDouble(map.get("zoom")));
		model.setBearing(Double.parseDouble(map.get("bearing")));
		model.setPitch(Double.parseDouble(map.get("pitch")));
		
		return model;
		
	}
	
}

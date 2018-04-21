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
				String solution = splits[1];
				String token = splits[2];

				Map<String, String> map = new HashMap<>();
				map.put("name", mapName);
				map.put("solution", solution);
				map.put("token", token);

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
		
		return model;
		
	}
	
}

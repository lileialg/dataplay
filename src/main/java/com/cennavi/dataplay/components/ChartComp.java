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

import com.cennavi.dataplay.model.ModelChart;
import com.cennavi.dataplay.model.ModelComp;

@Component
public class ChartComp {

	@Value("${chart.init.path}")
	private String path;
	
	@Value("${chart.image.url.prefix}")
	private String imagePrefixUrl;

	private Map<String, Map<String, String>> chartInfo = new HashMap<>();
	
	private void init() throws FileNotFoundException{
		

		if (chartInfo.size() == 0) {

			Scanner scanner = new Scanner(new FileInputStream(path));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				

				String[] splits = line.split(",");
				String mapName = splits[0];
				
				
				String solution = splits[1];


				Map<String, String> map = new HashMap<>();
				map.put("name", mapName);
				map.put("solution", solution);
				

				chartInfo.put(solution, map);
			}

			scanner.close();

		}
	}

	public List<ModelComp> chartList(String name)
			throws FileNotFoundException {

		init();

		List<ModelComp> list = new ArrayList<>();

		Set<Map.Entry<String, Map<String, String>>> set = chartInfo
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
	
	public ModelChart chart(String id) throws FileNotFoundException{
		
		init();
		
		ModelChart model = new ModelChart();
		
		
		
		return model;
		
	}
	
}

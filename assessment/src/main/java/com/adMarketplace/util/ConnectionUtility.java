package com.adMarketplace.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConnectionUtility {
	
	//Method to return a map object for each city connected to all cities
	public static Map<String, Set<String>> getConnectionMapping(String filepath) {
		Map<String, Set<String>> cityConnections = new HashMap<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String line;
			while((line = br.readLine()) != null) {
				String[] cities = line.split(",");
				if(cities.length == 2) {
					String city1 = cities[0].trim();
					String city2 = cities[1].trim();
					
					cityConnections.putIfAbsent(city1.toLowerCase(), new HashSet<>());
					cityConnections.get(city1.toLowerCase()).add(city2.toLowerCase());
					
					cityConnections.putIfAbsent(city2.toLowerCase(), new HashSet<>());
					cityConnections.get(city2.toLowerCase()).add(city1.toLowerCase());
				}
			}
		} catch (IOException ex) {
			System.out.println(ex);
		} 
		
		return cityConnections;
		
	}

	//Method to return a boolean based on connection between two cities using dfs
	public static boolean isConnected(String firstCity, String sceondCity, Map<String, Set<String>> cityConnections) {
		
		if(!cityConnections.containsKey(firstCity) || !cityConnections.containsKey(sceondCity))
			return false;
		
		Set<String> visited = new HashSet<String>();
		
		return dfs(firstCity, sceondCity, cityConnections, visited);
		
	}

	private static boolean dfs(String firstCity, String secondCity, Map<String, Set<String>> cityConnections,
			Set<String> visited) {
		
		if(visited.contains(firstCity))
			return false;
		
		visited.add(firstCity);
		
		if(firstCity.equals(secondCity))
			return true;
		
		for (String next : cityConnections.get(firstCity)) {
			if (dfs(next, secondCity, cityConnections, visited)) {
				return true;
			}
		}
			
		
		return false;
	}
	
}

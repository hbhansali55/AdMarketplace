package com.adMarketplace.service;

import java.util.Map;
import java.util.Set;
import com.adMarketplace.util.ConnectionUtility;

public class Connections {
	
	//Method to test connection between two cities
	public static boolean getConnection(String firstCity, String sceondCity, String filepath) {
		Map<String, Set<String>> cityConnections;
		cityConnections = ConnectionUtility.getConnectionMapping(filepath);
		boolean isConnected = ConnectionUtility.isConnected(firstCity.toLowerCase(), sceondCity.toLowerCase(), cityConnections);
		
		return isConnected;
	}
	
}

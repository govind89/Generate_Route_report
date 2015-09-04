package com.go.route;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.go.to.FareAttr;
import com.go.to.FareRules;
import com.go.to.Routes;

public class HashFiles {

	static HashMap<Integer, Integer> listRoutes = new HashMap<Integer, Integer>();
	static Map<String, String> finalRoutesCount = new LinkedHashMap<String, String>();
	static Map<String, String> finalRoutesPrice = new LinkedHashMap<String, String>();
	static int count = 1;

	public static Map<String, String> sumRoute(
			TreeMap<String, Routes> routeHashMap) {
	//	finalRoutesCount.put("route_type", "num_routes");
		for (Map.Entry<String, Routes> entry : routeHashMap.entrySet()) {
			countValues(entry.getValue().getRoute_type(), entry.getKey());
		}
		for (Map.Entry<Integer, Integer> entryRoutes : listRoutes.entrySet()) {
			finalRoutesCount.put(entryRoutes.getKey().toString(),RouteInfo.routeDesc.get(entryRoutes.getKey())+","+entryRoutes.getValue().toString());
		}

		/*for (Map.Entry<String, String> entryValRoutes : finalRoutesCount
				.entrySet()) {
			System.out.println(entryValRoutes.getKey() + "-"
					+ entryValRoutes.getValue());
		}*/

		return finalRoutesCount;
	}

	// count value based on key.
	public static void countValues(int key, String value) {
		if (listRoutes.containsKey(key)) {
			count = listRoutes.get(key);
			count++;
			listRoutes.put(key, count);
		} else {
			count = 1;
			listRoutes.put(key, count);
		}
	}

	public static Map<String, String> joinRoute(TreeMap<String, Routes> routeHashMap,
			TreeMap<String, FareRules> fairRulesMap,
			TreeMap<String, FareAttr> fairAttrMap) {
		int countVal = 0;
		for (Map.Entry<String, Routes> entry : routeHashMap.entrySet()) {
			String keyCheckVal = entry.getKey();
			if (fairRulesMap.containsKey(keyCheckVal)) {
				String fairId = fairRulesMap.get(keyCheckVal).getFare_id();
				finalRoutesPrice.put(keyCheckVal, entry.getValue()
						.getRoute_short_name()
						+ ","
						+ entry.getValue().getRoute_long_name()
						+ ","
						+ fairAttrMap.get(fairId).getPrice());
				// System.out.println("route :"+fairRulesMap.get(keyCheckVal).getRoute_id()+",fairId :"+fairRulesMap.get(keyCheckVal).getFare_id()+"price :"+fairAttrMap.get(fairId).getPrice());
			} else {
				finalRoutesPrice.put(keyCheckVal, entry.getValue()
						.getRoute_short_name()
						+ ","
						+ entry.getValue().getRoute_long_name() + ",");
			}
		}

	for (Entry<String, String> entry : finalRoutesPrice.entrySet()) {
			System.out.println(entry.getKey() + ","
					+ entry.getValue());
		}
		return finalRoutesPrice;
	}
}
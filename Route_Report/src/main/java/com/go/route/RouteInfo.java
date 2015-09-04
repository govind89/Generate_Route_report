package com.go.route;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.go.to.FareAttr;
import com.go.to.FareRules;
import com.go.to.Routes;

public class RouteInfo {

	static HashMap<Integer, String> routeDesc = new HashMap<Integer, String>();

	static TreeMap<String, Routes> routeMap = new TreeMap<String, Routes>();
	static TreeMap<String, FareRules> fairRulesMap = new TreeMap<String, FareRules>();
	static TreeMap<String, FareAttr> fairAttrMap = new TreeMap<String, FareAttr>();

	public static void main(String[] args) throws IOException {
		// checking args Value

		if (args.length != 1) {
			System.out
					.println("Please enter a Valid Parameters: <input_Path> <output_Path>");
		}

		String inputPath = args[0].toString();
		// String outputPath = args[1].toString()+"\\";

		try {

			// creating routedesc information.
			routeDesc
					.put(0,
							"Tram | Streetcar | Light rail. Any light rail or street level system within a metropolitan area.");
			routeDesc
					.put(1,
							"Subway | Metro. Any underground rail system within a metropolitan area.");
			routeDesc.put(2,
					"Rail. Used for intercity or long-distance travel.");
			routeDesc.put(3,
					"Bus. Used for short- and long-distance bus routes.");
			routeDesc.put(4,
					"Ferry. Used for short- and long-distance boat service.");
			routeDesc
					.put(5,
							"Cable car. Used for street-level cable cars where the cable runs beneath the car.");
			routeDesc
					.put(6,
							"Gondola | Suspended cable car. Typically used for aerial cable cars where the car is suspended from the cable.");
			routeDesc.put(7,
					"Funicular. Any rail system designed for steep inclines.");

			File parentDir = new File(inputPath);
			// reading necessary files from the input path.
			String[] inputFiles = { "routes.txt", "fare_attributes.txt",
					"fare_rules.txt" };

			for (String file : inputFiles) {
				String fileSrc = parentDir + "/" + file;
				InputStream in = new FileInputStream(new File(fileSrc));
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				String mapName = file.substring(0, file.indexOf('.'));
				fileToMap(reader, mapName);
				// Process 1) Total number of routes by route_type:
			}

			Map<String, String> finalRoutesCount = HashFiles.sumRoute(routeMap);
			Map<String, String> finalRoutesPrice = HashFiles.joinRoute(
					routeMap, fairRulesMap, fairAttrMap);

			CSVWriter writer = new CSVWriter();

			// write to csv files
			writer.writeCsvFile("routes_typ_count.csv", finalRoutesCount,
					"route_type,num_routes");
			writer.writeCsvFile("routes_cost.csv", finalRoutesPrice,
					"route_short_name,route_long_name,price");

		} catch (IOException e) {
			System.err
					.println("File could not be read. Please check if the files are placed in the input path given.");
			e.printStackTrace();
		}
	}

	public static void fileToMap(BufferedReader reader, String filename)
			throws IOException {
		// Initialize HashMaps

		String line;

		// Adding the Routes File content to Hash Map
		if (filename.equals("routes")) {
			String[] record = null;
			String routeHeader = reader.readLine();

			while ((line = reader.readLine()) != null) {
				record = line.split(",", -1);
				Routes route = new Routes();
				// route_id,agency_id,route_short_name,route_long_name,route_desc,route_type,route_url,route_color,route_text_color
				route.setRoute_id(record[0].trim());
				route.setAgency_id(record[1].trim());
				route.setRoute_short_name(record[2].trim());
				route.setRoute_long_name(record[3].trim());
				route.setRoute_desc(record[4].trim());
				route.setRoute_type(Integer.parseInt(record[5].trim()));
				route.setRoute_url(record[6].trim());
				route.setRoute_color(record[7].trim());
				route.setRoute_text_color(record[8].trim());
				routeMap.put(route.getRoute_id(), route);
			}
		} else if (filename.equals("fare_attributes")) {
			// Adding the Attributes File content to Hash Map
			String fairAttrHeader = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] record = null;
				record = line.split(",", -1);
				FareAttr fareAttribute = new FareAttr();
				// fare_id,price,currency_type,payment_method,transfers,transfer_duration
				fareAttribute.setFare_id(record[0].trim());
				fareAttribute.setPrice(Double.parseDouble(record[1].trim()));
				fareAttribute.setCurrency_type(record[2]);
				fareAttribute.setPayment_method(record[3].trim());
				fareAttribute.setTransfers(record[4].trim());
				fareAttribute.setTransfer_duration(record[5].trim());
				fairAttrMap.put(fareAttribute.getFare_id(), fareAttribute);
			}

		} else {
			// Adding the FairRules File content to Hash Map
			int lineNumber = 0;
			String fairRulesHeader = reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] record = null;
				record = line.split(",", -1);
				FareRules fareRule = new FareRules();
				// fare_id,route_id,origin_id,destination_id,contains_id
				fareRule.setFare_id(record[0].trim());
				fareRule.setRoute_id(record[1].trim());
				fareRule.setOrigin_id(record[2].trim());
				fareRule.setDestination_id(record[3].trim());
				fareRule.setContains_id(record[4].trim());
				fairRulesMap.put(fareRule.getRoute_id(), fareRule);
			}

		}
	}
}
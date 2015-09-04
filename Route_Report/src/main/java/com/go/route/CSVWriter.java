package com.go.route;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CSVWriter {

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	public void csvFileWrite() {

	}

	// write to csv file .
	public static void writeCsvFile(String fileName, Map<String, String> data,
			String header) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			// Total number of routes by route_type: routes_typ_count.csv
			// Cost of routes: routes_cost.csv

			// write hashmap value into csv File .
			fileWriter.append(header.toString());
			fileWriter.append(NEW_LINE_SEPARATOR);

			for (Map.Entry<String, String> entry : data.entrySet()) {
				String record = entry.getValue().toString();
				fileWriter.append(record.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			System.out.println("Data written to file "+fileName);
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out
						.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}
	}

}

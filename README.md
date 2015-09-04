# Generate_Route_report

Summary :
-----------

This Code Snippet will take  files from GFTS format files and generate reports on it. 

http://www.sfmta.com/about-sfmta/reports/gtfs-transit-data

The data is available in GTFS format which is documented here:
https://developers.google.com/transit/gtfs/reference

Details :
-----------

This Project takes route data and generate CSV file reports on data.

Input Files Format:

This Code Snippet will take files from GFTS format files and generate reports on it.

http://www.sfmta.com/about-sfmta/reports/gtfs-transit-data

The data is available in GTFS format which is documented here: https://developers.google.com/transit/gtfs/reference


Downloading
-----------

This Project could be checked out from Repository URL :

https://github.com/govind89/Generate_Route_report

Documentation
-------------


#STEPS TO REPORT GENERATION :

**Step 1** - Clone this Project in your home/desktop directory. 

				git clone git://github.com/govind89/Generate_Route_report.git Route_Report

**Step 2** : Build Project and Jar will be created in /target folder.

				cd Route_Report
				mvn clean package

**Step 3** - Check Jar file in target folder named routeInfo-0.1.jar 

**Step 5** - Execute  Command:
				
				*java -cp  <jar-File> <MainClass> <input_Path>*
				
				*jar-File* : routeInfo-0.1.jar
				*MainClass*  : com.go.route.RouteInfo
				*input_Path* : where GTFS Transit Data files are present.
				

Development
-----------
Code Development : Eclipse ,Core JAVA

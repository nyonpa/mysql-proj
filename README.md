JDBC ( Java Database Connectivity ) ( easier and advance version: hibernate and spring JDBC)

Data: raw or unprocessed information.
java application -------jdbc ----------database

Steps involved in developing JDBC Application:
1 	import required packages ( also download JDBC driver and add database specific jar file into the project ). jdk contains only the abstract methods and actual implementation are done by specific 			vendors, hence we need to download it from the vendor's site. whereas other feature like array, list are implemented by java so its available with in the jdk.

	2 	loading and registering the JDBC driver. eg MySQL
	3	Establish the connection
	4	Create the statement
	5 	execute the query
	6 	process the result
	7 	close the connection
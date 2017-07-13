package lesson4;

import java.sql.*;

public class HomeWork2 {
	
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "12345";

    Connection createSqlQuery(String myQuery) throws SQLException {         //Connection to database;
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate(myQuery);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return connection;
    }
    
    
	public static void main(String[] argv) throws ClassNotFoundException, SQLException {
		System.out.println("4. Write SQL queries for creation these tables (airports, flights, airlines)\n"
				+ "in your local database. Create necessary tablesin your local database using these queries.\n"
				+ "Pay attention that you mightneed to add primary key columns for relation between tables.");
        System.out.println("======================= Solution ==============================");
        
        String myQuery = "";
        HomeWork2 One = new HomeWork2();
        
        myQuery = "CREATE TABLE `airports` ( " +
        "`airport` char(20) NOT NULL, " +
        "`dutyFree` char(3) NOT NULL, " +
        "`priorityBoarding` char(3) NOT NULL, " +
        "PRIMARY KEY (`airport`) " +
        ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
   		  
        One.createSqlQuery(myQuery);
        
        System.out.println("The table airports was created.");

        myQuery = "CREATE TABLE `flights` (" +
        "`flightNumber` int(4) NOT NULL, " +
        "`departureAirport` char(20) NOT NULL, " +
        "`arrivalAirport` char(20) NOT NULL, " +
        "`stopsNumber` tinyint(1) NOT NULL, " +
        "`averageTicketPrice` int(4) NOT NULL, " +
        "`availableSeats` int(4) NOT NULL, " +        
        "PRIMARY KEY (`flightNumber`)" +
        ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        
        One.createSqlQuery(myQuery);
        
        System.out.println("The table flights was created.");
        
        myQuery = "CREATE TABLE `airlines` " +
        "(`flightNumber` int(4) NOT NULL, " +
        "`airline` char(20) NOT NULL, " +
        "`additionalSpaceService` char(3) NOT NULL, " +
        "`webRegistration` char(3) NOT NULL, " +
        "`isMealincluded` char(3) NOT NULL, " +
        "PRIMARY KEY (`flightNumber`)" +
        ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        
        One.createSqlQuery(myQuery);
        
        System.out.println("The table airlines was created.");
        System.out.println("");
        
		        
		System.out.println("5. Write SQL queries for filling tables by valid data.\n"
				+ "Fill tables in your local database using these queries.");
        System.out.println("======================= Solution ==============================");

        myQuery = "INSERT INTO `airports` VALUES ('Barcelona','yes','no'),('Beijing','no','yes'),('Berlin','yes','no'),('Budapest','yes','no')," +
        "('Helsinki','no','no'),('Kiev','yes','yes'),('London','yes','yes'),('Milan','yes','yes'),('Munich','yes','no'),('New York','no','no')," +
        "('Ottava','no','no'),('Paris','yes','yes'),('Prague','yes','yes'),('Sydney','no','no'),('Vilnus','yes','yes');";
        One.createSqlQuery(myQuery);
        System.out.println("The table airports was filled.");
        
        myQuery = "INSERT INTO `flights` VALUES (1001,'London','Munich',0,90,12),(1002,'London','New York',1,300,0),(1003,'London','Ottava',1,290,2)," +
        "(1004,'London','Milan',0,45,33),(1005,'New York','Sydney',2,681,17),(1006,'New York','Kiev',1,220,80),(1007,'New York','Milan',1,440,1)," +
        "(1008,'New York','Barcelona',0,375,14),(1009,'New York','Prague',1,410,21),(1010,'New York','Helsinki',1,200,5),(1011,'Budapest','London',0,15,47)," +
        "(1012,'Budapest','Kiev',0,39,0),(1013,'Budapest','Vilnus',0,50,11),(1014,'Beijing','Helsinki',2,190,33),(1015,'Beijing','Barcelona',1,149,13)," +
        "(1016,'Sydney','Berlin',1,800,13),(1017,'Sydney','Munich',1,1200,13),(1018,'Sydney','Milan',1,1000,9),(1019,'Paris','Ottava',1,999,2)," +
        "(1020,'Paris','Vilnus',0,67,3),(1021,'Paris','Helsinki',0,95,10),(1022,'Paris','New York',0,212,10),(1023,'Kiev','New York',2,220,25)," +
        "(1024,'Kiev','Milan',0,99,8),(1025,'Munich','London',0,15,0),(1026,'Ottava','Vilnus',1,333,0),(1027,'Ottava','Milan',1,310,1)," +
        "(1028,'Ottava','Barcelona',1,310,4),(1029,'Berlin','Kiev',0,87,7),(1030,'Prague','Helsinki',1,87,23),(1031,'Barcelona','Ottava',1,310,6)," +
        "(1032,'Helsinki','Budapest',0,94,8),(1033,'Milan','Beijing',2,190,0),(1034,'Milan','Sydney',2,725,2),(1035,'Vilnus','Munich',0,41,100);";
        One.createSqlQuery(myQuery);
        System.out.println("The table flights was filled.");
        
        myQuery = "INSERT INTO `airlines` VALUES (1001,'WizzAir','yes','no','no'),(1002,'WizzAir','no','no','no'),(1003,'Lufthansa','no','yes','no')," +
        "(1004,'Lufthansa','yes','yes','yes'),(1005,'Lufthansa','no','no','yes'),(1006,'Lufthansa','yes','no','yes'),(1007,'Windrose Aero','yes','no','yes')," +
        "(1008,'Windrose Aero','yes','no','yes'),(1009,'WizzAir','no','no','no'),(1010,'Cathay Pacific','no','yes','yes'),(1011,'Cathay Pacific','yes','yes','no')," +
        "(1012,'Austrian Airlines','no','yes','yes'),(1013,'AirAsia','no','yes','yes'),(1014,'Virgin','no','yes','yes'),(1015,'Virgin','yes','no','no')," +
        "(1016,'Virgin','yes','yes','no'),(1017,'AirAsia','no','no','no'),(1018,'Emirates','yes','yes','yes'),(1019,'Ryanair','no','no','no')," +
        "(1020,'AirAsia','yes','no','yes'),(1021,'Windrose Aero','no','no','no'),(1022,'WizzAir','no','no','no'),(1023,'AirAsia','yes','yes','yes')," +
        "(1024,'AirAsia','no','no','no'),(1025,'Emirates','yes','yes','yes'),(1026,'WizzAir','yes','no','yes'),(1027,'Emirates','no','yes','no')," +
        "(1028,'Austrian Airlines','no','no','no'),(1029,'Turkish Airlines','yes','yes','yes'),(1030,'Air France','yes','no','no')," +
        "(1031,'Air France','yes','no','yes'),(1032,'Air France','yes','yes','no'),(1033,'Air France','no','yes','no'),(1034,'WizzAir','no','yes','no')," +
        "(1035,'Ryanair','no','yes','no');";
        One.createSqlQuery(myQuery);
        System.out.println("The table airlines was filled.");
        System.out.println("");

     
		System.out.println("6. Based on tables and user-stories write checklists (in excel-format) for checking all tables\n"
				+ "fields in simple, complex scenarios and user-stories.");
        System.out.println("======================= Solution ==============================");
        
        System.out.println("The excel file checklists.xls with checklists for checking all tables was created.");
        System.out.println("");


		System.out.println("7. Create collection of SQL-queries to your database for checking all this checklists.");
        System.out.println("======================= Solution ==============================");
        
        System.out.println("The collection of SQL - queries was created in separate class Collection.");
        System.out.println("");
 
		System.out.println("8. Design automated test framework for testing all scenarios.");
        System.out.println("======================= Solution ==============================");
        
        
    	}
}
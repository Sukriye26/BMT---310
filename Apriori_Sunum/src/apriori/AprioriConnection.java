package apriori;

import java.sql.Connection;
import java.sql.DriverManager;

public class AprioriConnection {
	private static AprioriConnection instance = null;
	private Connection con;

	AprioriConnection() {
		try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con=DriverManager.getConnection(
                   "jdbc:oracle:thin:@localhost:1521:xe","SUKRIYE","26");

            System.out.println("connection is succesfull");

        }catch(Exception e){ System.out.println(e);}
	}

	public static AprioriConnection getInstance() {
		if (instance == null)
			instance = new AprioriConnection();
		return instance;
	}

	public Connection getCon() {
		return con;
	}
}

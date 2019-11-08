package ee.hibernate.reneroost.harjutamine;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/tootaja_tracker?useSSL=false&serverTimezone=UTC";
		String kasutaja = "tootaja";
		String parool = "tootaja";
		
		try {
			System.out.println("Andmebaasi ühendamine: " + jdbcUrl);
			Connection minuUhendus = DriverManager.getConnection(jdbcUrl, kasutaja, parool);
			System.out.println("Ühendus edukas");
		} catch(Exception erind) {
			erind.printStackTrace();
		}
	}

}

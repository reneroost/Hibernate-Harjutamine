package ee.hibernate.reneroost.harjutamine.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ee.hibernate.reneroost.harjutamine.olem.Tootaja;

public class LooTootajaDemo {

	public static void main(String[] args) {
		
		SessionFactory tehas = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Tootaja.class)
				.buildSessionFactory();
		
		Session sessioon = tehas.getCurrentSession();
		
		try {
			System.out.println("Loon uut töötaja objekti");
			Tootaja ajutineTootaja = new Tootaja("Peeter", "Kuusk", "kuusepets@hot.ee");
			sessioon.beginTransaction();
			sessioon.save(ajutineTootaja);
			sessioon.getTransaction().commit();
			System.out.println("Kõik tehtud!");
		} finally {
			tehas.close();
		}
	}
}

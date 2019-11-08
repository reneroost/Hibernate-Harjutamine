package ee.hibernate.reneroost.harjutamine.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ee.hibernate.reneroost.harjutamine.olem.Tootaja;

public class EsmaneVotiDemo {

	public static void main(String[] args) {
		SessionFactory tehas = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Tootaja.class)
				.buildSessionFactory();
		
		Session sessioon = tehas.getCurrentSession();
		
		try {
			System.out.println("Loon 3 uut töötaja objekti");
			Tootaja ajutineTootaja1 = new Tootaja("Marju", "Mall", "mallemarju@hot.ee");
			Tootaja ajutineTootaja2 = new Tootaja("Peeter", "Kuusk", "kuusepets@hot.ee");
			Tootaja ajutineTootaja3 = new Tootaja("Anne", "Mädarõigas", "roikaanne@hot.ee");
			sessioon.beginTransaction();
			sessioon.save(ajutineTootaja1);
			sessioon.save(ajutineTootaja2);
			sessioon.save(ajutineTootaja3);
			sessioon.getTransaction().commit();
			System.out.println("Kõik salvestatud!");
		} finally {
			tehas.close();
		}
	}
}

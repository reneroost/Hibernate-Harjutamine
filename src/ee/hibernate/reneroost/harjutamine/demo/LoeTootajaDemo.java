package ee.hibernate.reneroost.harjutamine.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ee.hibernate.reneroost.harjutamine.olem.Tootaja;

public class LoeTootajaDemo {

	public static void main(String[] args) {
		
		SessionFactory tehas = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Tootaja.class)
				.buildSessionFactory();
		
		Session sessioon = tehas.getCurrentSession();
		
		try {
			System.out.println("Loon uut t��taja objekti");
			Tootaja ajutineTootaja = new Tootaja("Kalju", "Kaljurand", "kalju2x@hot.ee");
			sessioon.beginTransaction();
			System.out.println(ajutineTootaja);
			sessioon.save(ajutineTootaja);
			sessioon.getTransaction().commit();
			System.out.println("T��taja salvestatud! Genereeritud ID: " + ajutineTootaja.getId());
			
			sessioon = tehas.getCurrentSession();
			sessioon.beginTransaction();
			System.out.println("\nSaan t��taja ID-ga: " + ajutineTootaja.getId());
			Tootaja minuTootaja = sessioon.get(Tootaja.class, ajutineTootaja.getId());
			System.out.println("Saamine l�pule viidud " + minuTootaja);
			sessioon.getTransaction().commit();
		} finally {
			tehas.close();
		}
	}
}

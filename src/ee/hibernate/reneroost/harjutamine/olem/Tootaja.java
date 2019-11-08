package ee.hibernate.reneroost.harjutamine.olem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tootaja")
public class Tootaja {

	@Id()
	@Column(name="id")
	private int id;
	
	@Column(name="ees_nimi")
	private String eesNimi;
	
	@Column(name="pere_nimi")
	private String pereNimi;
	
	@Column(name="email")
	private String email;
	
	public Tootaja() {}

	public Tootaja(String eesNimi, String pereNimi, String email) {
		this.eesNimi = eesNimi;
		this.pereNimi = pereNimi;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEesNimi() {
		return eesNimi;
	}

	public void setEesNimi(String eesNimi) {
		this.eesNimi = eesNimi;
	}

	public String getPereNimi() {
		return pereNimi;
	}

	public void setPereNimi(String pereNimi) {
		this.pereNimi = pereNimi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Tootaja [id=" + id + ", eesNimi=" + eesNimi + ", pereNimi=" + pereNimi + ", email=" + email + "]";
	}
	
	
}

package com.codingassignment7;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Telecombhaarti")
public class Telecombhaarti {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String cname;
	String plan;
	int mobiNo;
	String city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public int getMobiNo() {
		return mobiNo;
	}
	public void setMobiNo(int mobiNo) {
		this.mobiNo = mobiNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Telecombhaarti() {
		super();
	}
	public Telecombhaarti(int id, String cname, String plan, int mobiNo, String city) {
		super();
		this.id = id;
		this.cname = cname;
		this.plan = plan;
		this.mobiNo = mobiNo;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Telecombhaarti [id=" + id + ", cname=" + cname + ", plan=" + plan + ", mobiNo=" + mobiNo + ", city="
				+ city + "]";
	}
}

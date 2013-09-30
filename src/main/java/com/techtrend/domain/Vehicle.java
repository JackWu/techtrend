package com.techtrend.domain;

public class Vehicle {
	private String id;
	private String color;
	private int wheel;
	private int seat;
	
	public Vehicle(){
		
	}
	
	public Vehicle(String id, String color, int wheel, int seat){
		this.id = id;
		this.color = color;
		this.wheel = wheel;
		this.seat = seat;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWheel() {
		return wheel;
	}
	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	

}

package com.techtrend.web.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class CreateVehicleForm {

	@NotEmpty(message = "color is required")
	private String color;
	@Min(value=1, message="wheel must be bigger than 1")
	private int wheel;
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	@Min(value=1, message="seat must be bigger than 1")
	private int seat;

	

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

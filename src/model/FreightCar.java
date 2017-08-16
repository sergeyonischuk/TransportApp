package model;

import enums.Comfortableness;

public class FreightCar extends Car {

	private FreightCar(Comfortableness comfortableness) {
		super(comfortableness);
	}
	
	public FreightCar() {
		this(Comfortableness.FREIGHT);
	}

	@Override
	public String toString() {
		return "FreightCar [comfortableness=" + comfortableness + ", getComfortableness()="
				+ getComfortableness() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+  "]";
	}
}
package model;

import java.util.Comparator;

import enums.Comfortableness;

public abstract class Car {
	Comfortableness comfortableness;
	
	public Car(Comfortableness comfortableness) {
		this.comfortableness = comfortableness;
	}

	public Comfortableness getComfortableness() {
		return comfortableness;
	}

	public void setComfortableness(Comfortableness comfortableness) {
		this.comfortableness = comfortableness;
	}
	
	/**
	 * Sorting cars by comfortableness (ordinal).
	 *
	 */
	public static class SortByComfortableness implements Comparator<Car>{

		public int compare(Car o1, Car o2) {
			return o1.getComfortableness().compareTo(o2.getComfortableness());
		}
	}


}
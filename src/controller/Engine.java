package controller;

import java.util.ArrayList;
import java.util.List;

import model.PassengerCoach;
import model.PassengerTrain;

public class Engine {
	
	/**
	 * Without buffetCar places.
	 * @param train
	 * @return total train seats.
	 */
	public int getTotalTrainSeats(PassengerTrain train) {
		int result = 0;
		int carsInTrain = train.getList().size();
		for (int i = 0; i < carsInTrain; i++) {
			if (train.getList().get(i) instanceof PassengerCoach) {
				PassengerCoach p = (PassengerCoach) train.getList().get(i);
				result += p.getPassengerSeats();
			}
		}
		return result;
	}
	
	public List<PassengerCoach> findCoachByNumberOfSeats(PassengerTrain train, int min, int max) {
		if (min > max) {
			System.out.println("min value must be less than max");
		}
		List<PassengerCoach> list = new ArrayList<PassengerCoach>();
		
		for (int i = 0; i < train.getList().size(); i++) {
			if (train.getList().get(i) instanceof PassengerCoach) {
				PassengerCoach p = (PassengerCoach) train.getList().get(i);
				if (p.getPassengerSeats() >= min && p.getPassengerSeats() <= max) {
					list.add(p);
				}
			}
		}
		return list;
	}

}

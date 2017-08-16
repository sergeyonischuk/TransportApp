package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.Comfortableness;
import enums.Fuel;
import model.BuffetCar;
import model.Car;
import model.FreightCar;
import model.Locomotive;
import model.PassengerCoach;
import model.PassengerTrain;


public class Main {
	

	public static void main(String[] args) throws Exception {
		

		
		Locomotive locomotive = new Locomotive(Fuel.DIESEL);
		
		List<Car> list = new ArrayList<Car>();
		list.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
		list.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
		list.add(new FreightCar());
		list.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		list.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
		list.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		list.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
		list.add(new BuffetCar(30, Comfortableness.FIRST_CLASS));
		list.add(new PassengerCoach(Comfortableness.PREMIUM));
		list.add(new PassengerCoach(Comfortableness.PREMIUM));
		list.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
		list.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		list.add(new BuffetCar(30, Comfortableness.SECOND_CLASS));
		list.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		list.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		list.add(new PassengerCoach(Comfortableness.COUPE));
		list.add(new PassengerCoach(Comfortableness.COUPE));
		list.add(new PassengerCoach(Comfortableness.COUPE));
		
		PassengerTrain pTrain = new PassengerTrain(locomotive, list, 137);
		Collections.sort(list, new Car.SortByComfortableness());
		

		

		List<Car> list2 = new ArrayList<Car>();
		Locomotive locomotive2 = new Locomotive(Fuel.COAL);
		list2.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
		list2.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		list2.add(new BuffetCar(30, Comfortableness.SECOND_CLASS));
		list2.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		list2.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		
		PassengerTrain pTrain2 = new PassengerTrain(locomotive2, list2, 114);
		
		List<PassengerTrain> trainList = new ArrayList<PassengerTrain>();
		trainList.add(pTrain);
		trainList.add(pTrain2);
		
		System.out.println(pTrain.getList().size());
		
		System.out.println(pTrain2.getList().size());

		
//		Connector.Conn();
//		Connector.CreateDB();
//		DataBaseEngine.addToDataBase(pTrain);
//		DataBaseEngine.addToDataBase(pTrain2);
//		Connector.ReadDB();
//		Connector.CloseDB();

		
	}
	

}
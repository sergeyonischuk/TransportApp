package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Comfortableness;
import enums.Fuel;
import model.BuffetCar;
import model.Car;
import model.FreightCar;
import model.Locomotive;
import model.PassengerCoach;
import model.PassengerTrain;

@WebServlet("/TransportServlet")
public class TransportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConcurrentHashMap<String, PassengerTrain> trains = new ConcurrentHashMap<>();
	
	@Override
	public void init() throws ServletException {
		Locomotive locomotive = new Locomotive(Fuel.DIESEL);
		
		List<Car> list = new ArrayList<Car>();
		try {
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
		} catch (Exception e) {
			
		}
		
		PassengerTrain pTrain = new PassengerTrain(locomotive, list, 137);
		Collections.sort(list, new Car.SortByComfortableness());
		
		Locomotive locomotive2 = new Locomotive(Fuel.COAL);
		List<Car> list2 = new ArrayList<Car>();

		try {

		list2.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
		list2.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		list2.add(new BuffetCar(30, Comfortableness.SECOND_CLASS));
		list2.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		list2.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
		

		
		} catch (Exception e) {
			
		}
		PassengerTrain pTrain2 = new PassengerTrain(locomotive2, list2, 114);
		trains.put("134", pTrain);
		trains.put("136", pTrain2);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String trainNumber = request.getParameter("trainNumber");
		
		PassengerTrain train = trains.get(trainNumber);
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		

		if (trains.containsKey(trainNumber)) {
			out.println("<h3>information about train № " + trainNumber + ": </h3>");
			out.println("number of cars: " + train.getList().size());
			out.println("locomotive: " + train.getLocomotive().getFuel());
		} else if (trains.containsKey(trainNumber)) {
			out.print("<h3>Поезда с номером " + trainNumber + " не существует в базе</h3>");

		} else {
			out.print("<h3>Вы не указали номер поезда</h3>");
		}
		
		out.print("<br>");
		out.print("<a href='http://localhost:8080/TransportApp/TrainSearch.html'>На главную страницу поиска</a>");
		out.close();
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		request.setCharacterEncoding("UTF-8");
//		
//		String name = request.getParameter("firstName");
//		String secondName = request.getParameter("secondName");
//		System.out.println(name);
//		System.out.println(secondName);
//		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<h3>hellosad " + name + " " + secondName + "</h3>");
//		out.close();
//	}

}

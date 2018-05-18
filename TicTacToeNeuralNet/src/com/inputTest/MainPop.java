package com.inputTest;

import java.util.ArrayList;

import com.geneticAlgorithm.Population;

public class MainPop {

	public static void main(String[] args) {
		
		Population pop = new Population(10, 9, 1);
		
		ArrayList<Double> test = new ArrayList<Double>();
		
		test.add(1.0);
		test.add(1.0);
		test.add(0.0);
		test.add(0.0);
		test.add(1.0);
		test.add(0.0);
		test.add(4.0);
		test.add(4.0);
		test.add(0.0);
		
		pop.giveTaskToAll(test);
		
		System.out.println(pop.getAllResults());
	}

}

package com.inputTest;
import java.util.ArrayList;

import com.network.*;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> topology = new ArrayList<Integer>();
		
		topology.add(9);
		topology.add(10);
		topology.add(1);
		
		Network net = new Network(topology);
		
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

		
		net.feedFoward(test);
		
		
		System.out.println((net.getdResults().get(0)+1)*4);

	}

}

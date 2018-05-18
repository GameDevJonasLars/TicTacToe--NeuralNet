package com.inputTest;
import java.util.ArrayList;

import com.network.*;

public class Main {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			
			ArrayList<Integer> topology = new ArrayList<Integer>();
			
			topology.add(9);
			topology.add(8);
			topology.add(7);
			topology.add(6);
			topology.add(5);
			topology.add(4);
			topology.add(3);
			topology.add(2);
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
		
		net.feedFoward(test);
		
		
		System.out.println((net.getdResults().get(0)+1)*4);

	}

}

package com.network;

import java.util.ArrayList;

public class Network {

	static private int iLayerNum;
	private ArrayList<Layer> lNetwork = new ArrayList<Layer>();
	private ArrayList<Double> dResults = new ArrayList<Double>();
	private double fitness;
	
	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public ArrayList<Double> getdResults() {
		return dResults;
	}

	public Network(ArrayList<Integer> iTopology) {
		
		int iNumOutputs;
		iLayerNum = iTopology.size();
		
		for(int i = 0; i < iLayerNum; i++) {	
			
			if(i == iTopology.size() - 1) {
				iNumOutputs = 0;
			}else {
				iNumOutputs = iTopology.get(i + 1);
			}
			
			lNetwork.add(new Layer(iTopology.get(i), iNumOutputs));	
		}
	}
	
	public boolean feedFoward(ArrayList<Double> dInput) {
		
		if(dInput.size() == lNetwork.get(0).nLayer.size() - 1) {
			lNetwork.get(0).giveInput(dInput);
			
			for (int i = 1; i < lNetwork.size(); i++) {
				Layer prevLayer = lNetwork.get(i - 1);
				lNetwork.get(i).feedFoward(prevLayer);
			}
			
			dResults.clear();
			
			for (int i = 0; i < lNetwork.get(lNetwork.size()-1).nLayer.size()-1; i++) {
				dResults.add(lNetwork.get(lNetwork.size()-1).nLayer.get(i).getdOutput());
			}
			
			return true;
		} else {
			return false;
		}
	}

}

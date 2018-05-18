package com.network;

import java.util.ArrayList;
import com.SomeFunktions.*;

public class Network {

	static private int iLayerNum;
	public ArrayList<Layer> lNetwork = new ArrayList<Layer>();
	private ArrayList<Double> dResults = new ArrayList<Double>();
	private double fitness;
	private ArrayList<Integer> iStructure = new ArrayList<Integer>();

	public Network(ArrayList<Integer> iStructure) {
		
		this.iStructure = iStructure;
		
		int iNumOutputs;
		iLayerNum = iStructure.size();
		
		for(int i = 0; i < iLayerNum; i++) {	
			
			if(i == iStructure.size() - 1) {
				iNumOutputs = 0;
			}else {
				iNumOutputs = iStructure.get(i + 1);
			}
			
			lNetwork.add(new Layer(iStructure.get(i), iNumOutputs));	
		}
	}
	
	public double[][][] getWeights(){
		
		double [][][] dWeights = 
				new double [lNetwork.size()][ArrayListFunktions.maxI(iStructure)][ArrayListFunktions.maxI(iStructure)];
		
		for (int i = 0; i < lNetwork.size(); i++) {
			for (int iZ = 0; iZ < lNetwork.get(i).nLayer.size(); iZ++) {
				for (int iX = 0; iX < lNetwork.get(i).nLayer.get(iZ).cNeuron.size(); iX++) {
					dWeights [i][iZ][iX] = lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight;				}
			}
		}
		
		return dWeights;
		
	}
	
	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public ArrayList<Double> getdResults() {
		return dResults;
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

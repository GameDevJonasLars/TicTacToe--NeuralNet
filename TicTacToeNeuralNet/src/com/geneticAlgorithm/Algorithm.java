package com.geneticAlgorithm;

import java.util.ArrayList;
import com.network.*;

public class Algorithm {

	ArrayList<Network> population = new ArrayList<Network>();
	int iInputsNum;
	int iOutputsNum;
	
	public void createPopulation(int iPopulationSize, int iInputsNum, int iOutputsNum) {
		this.iInputsNum = iInputsNum;
		this.iOutputsNum = iOutputsNum;
		
		for(int i = 0; i < iPopulationSize; i++) {
			
			ArrayList<Integer> iStructure = new ArrayList<Integer>();
			iStructure.add(iInputsNum);
			
			if (iInputsNum >= 3) {
				int iLayerNum = (int)(Math.random() * (iInputsNum-1)) + 2;
				int iMinNeuronNum = (int) ((iInputsNum*2)/iLayerNum);
				
				for (int iZ = 0; iZ <= iLayerNum; iZ++) {
					iStructure.add((int)(Math.random() * iMinNeuronNum) + iMinNeuronNum);
				}
			}
			else {
				int iLayerNum = 1;
				iStructure.add(iInputsNum*2);
			}
			iStructure.add(iOutputsNum);
			
			population.add(new Network(iStructure));
		}
	}
	
	public void setFitness(int iNetworkNum, double dFitness) {
		population.get(iNetworkNum).setFitness(dFitness);
	}
	
	public Boolean giveTask(ArrayList<Double> dInputs, int NetworkNum) {
		if (dInputs.size() == iInputsNum) {
			population.get(NetworkNum).feedFoward(dInputs);
			return true;
		}else {
			return false;
		}
	}
	
	public void selection() {
		
	}
	
	public void breed() {
		
	}
	
	public void mutate(int iNetworkNum) {
		
	}
	
	public void evolve() {
		
	}
	
	public void save() {
		
	}
	
	public void loadPopulation() {
		
	}
}
























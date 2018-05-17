package com.geneticAlgorithm;

import java.util.ArrayList;
import com.network.*;

public class Algorithm {

	ArrayList<Network> population = new ArrayList<Network>();
	int iInputsNum;
	int iOutputsNum;
	
	public Algorithm(int iPopulationSize, ArrayList<Integer> iTopology) {
		
		for(int i = 0; i < iPopulationSize; i++) {
			population.add(new Network(iTopology));
		}
	}
	
	public void createPopulation(int iPopulationSize, int iInputsNum, int iOutputsNum) {
		this.iInputsNum = iInputsNum;
		this.iOutputsNum = iOutputsNum;
		
		for(int i = 0; i < iPopulationSize; i++) {
			
			ArrayList<Integer> tropology = new ArrayList<Integer>();
			tropology.add(iInputsNum);
			tropology.add(iOutputsNum);
			
			if (iInputsNum >= 3) {
				int iLayerNum = (int)(Math.random() * (iInputsNum-1)) + 2;
				int iMinNeuronNum = (int) ((iInputsNum*2)/iLayerNum);
				
				for (int iZ = 0; i <= iLayerNum; i++) {
					tropology.add((int)(Math.random() * iMinNeuronNum) + iMinNeuronNum);
				}
			}
			else {
				int iLayerNum = 1;
				tropology.add(iInputsNum*2);
			}
			
			population.add(new Network(tropology));
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
}

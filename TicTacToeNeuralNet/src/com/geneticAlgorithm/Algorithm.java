package com.geneticAlgorithm;

import java.util.ArrayList;

import javax.xml.crypto.KeySelector.Purpose;

import com.network.*;

public class Algorithm {

	ArrayList<Network> population = new ArrayList<Network>();
	int iInputsNum;
	int iOutputsNum;
	
	public int createRandomPopulation(int iPopulationSize, int iInputsNum, int iOutputsNum) {
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
			return population.size()-1;
		}
		return 0;
		
	}
	public int createPopulation(ArrayList<Integer> alNetStruct, int iInputsNum, int iOutputsNum) {
		this.iInputsNum = iInputsNum;
		this.iOutputsNum = iOutputsNum;
		population.add(new Network(alNetStruct));
		return population.size()-1;
		
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
	
	public Boolean giveTaskToAll(ArrayList<Double> dInputs) {
		
		
		if (dInputs.size() == iInputsNum) {
			for (int i = 0; i < population.size(); i++) {
				population.get(i).feedFoward(dInputs);
			}
			return true;
		}else {
			return false;
		}
	}
	
	public ArrayList<Double> getResults(int iNetworkNum) { 
		ArrayList<Double> dResults = new ArrayList<Double>();

		dResults = population.get(iNetworkNum).getdResults();
		
		return dResults;
	}
	
	public ArrayList<ArrayList<Double>> getAllResults() {
		ArrayList<ArrayList<Double>> dAllResults = new ArrayList<ArrayList<Double>>();
		
		for (int i = 0; i < population.size(); i++) {
			dAllResults.add(population.get(i).getdResults());
		}
		return dAllResults;
	}
	
	public double calcFitness(ArrayList<Double> dResults, ArrayList<Double> dExpectedResults) {
		if (dResults.size() == dExpectedResults.size()) {
			double fitness = 0;
			
			for (int i = 0; i < dResults.size(); i++) {
				fitness += Math.abs(dExpectedResults.get(i) - dResults.get(i));
			}
			
			fitness = fitness / dResults.size();
			fitness = 100 - fitness;
			
			return fitness;
		}
		return 1000;
	}
	
	public void automaticEvolve (ArrayList<Double> dInputs, ArrayList<Double> dResults) {
		giveTaskToAll(dInputs);
		
		
	}
	
	public void selection() {
		
	}
	
	public void breed() {
		
	}
	
	public void mutate(int iNetworkNum) {
		
		for (int i = 0; i < population.get(i).lNetwork.size(); i++) {
			for (int iZ = 0; iZ < population.get(i).lNetwork.get(i).nLayer.size(); iZ++) {
				for (int iX = 0; iX < population.get(i).lNetwork.get(i).nLayer.get(iZ).cNeuron.size(); iX++) {
					population.get(i).lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight += (Math.random()*0.1)-0.1;
				}
			}
		}
		
	}
	
	public void evolve() {
		
	}
	
	public void save() {
		
	}
	
	public void loadPopulation() {
		
	}
}
























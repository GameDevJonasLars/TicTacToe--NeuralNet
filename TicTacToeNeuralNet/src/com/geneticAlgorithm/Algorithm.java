package com.geneticAlgorithm;

import java.util.ArrayList;

import javax.xml.crypto.KeySelector.Purpose;

import com.network.*;

public class Algorithm {

	ArrayList<Network> population = new ArrayList<Network>();
	ArrayList<Integer> alInputNum = new ArrayList<Integer>();
	ArrayList<Integer> alOutputNum = new ArrayList<Integer>();

	public void createRandomPopulation(int iPopulationSize, int iInputsNum, int iOutputsNum) {

		for (int i = 0; i < iPopulationSize; i++) {

			ArrayList<Integer> iStructure = new ArrayList<Integer>();
			iStructure.add(iInputsNum);

			if (iInputsNum >= 3) {
				int iLayerNum = (int) (Math.random() * (iInputsNum - 1)) + 2;
				int iMinNeuronNum = (int) ((iInputsNum * 2) / iLayerNum);

				for (int iZ = 0; iZ <= iLayerNum; iZ++) {
					iStructure.add((int) (Math.random() * iMinNeuronNum) + iMinNeuronNum);
				}
			} else {
				int iLayerNum = 1;
				iStructure.add(iInputsNum * 2);
			}
			iStructure.add(iOutputsNum);

			population.add(new Network(iStructure));
			
			alInputNum.add(iInputsNum);
			alOutputNum.add(iOutputsNum);
		}
	}
	
	public void addRandomNetwork(int iInputsNum, int iOutputsNum) {

		ArrayList<Integer> iStructure = new ArrayList<Integer>();
		iStructure.add(iInputsNum);

		if (iInputsNum >= 3) {
			int iLayerNum = (int) (Math.random() * (iInputsNum - 1)) + 2;
			int iMinNeuronNum = (int) ((iInputsNum * 2) / iLayerNum);

			for (int iZ = 0; iZ <= iLayerNum; iZ++) {
				iStructure.add((int) (Math.random() * iMinNeuronNum) + iMinNeuronNum);
			}
		} else {
			int iLayerNum = 1;
			iStructure.add(iInputsNum * 2);
		}
		iStructure.add(iOutputsNum);
			
		population.add(new Network(iStructure));
			
		alInputNum.add(iInputsNum);
		alOutputNum.add(iOutputsNum);
		
	}
	
	public Network createRandomNetwork(int iInputsNum, int iOutputsNum) {

		ArrayList<Integer> iStructure = new ArrayList<Integer>();
		iStructure.add(iInputsNum);

		if (iInputsNum >= 3) {
			int iLayerNum = (int) (Math.random() * (iInputsNum - 1)) + 2;
			int iMinNeuronNum = (int) ((iInputsNum * 2) / iLayerNum);

			for (int iZ = 0; iZ <= iLayerNum; iZ++) {
				iStructure.add((int) (Math.random() * iMinNeuronNum) + iMinNeuronNum);
			}
		} else {
			int iLayerNum = 1;
			iStructure.add(iInputsNum * 2);
		}
		iStructure.add(iOutputsNum);
			
		Network net = new Network(iStructure);
		return net;
	}
	
	public void setNetwork (int iIndex, Network net) {
		population.set(iIndex, net);
	}

	public int createPopulation(ArrayList<Integer> alNetStruct, int iInputsNum, int iOutputsNum) {
		alInputNum.add(iInputsNum);
		alOutputNum.add(iOutputsNum);
		population.add(new Network(alNetStruct));
		return population.size() - 1;

	}
	
	public int size() {
		return population.size();
	}

	public void setFitness(int iNetworkNum, double dFitness) {
		population.get(iNetworkNum).setFitness(dFitness);
	}

	public Boolean giveTask(ArrayList<Double> dInputs, int NetworkNum) {
		if (dInputs.size() == alInputNum.get(NetworkNum)) {
			population.get(NetworkNum).feedFoward(dInputs);
			return true;
		} else {
			return false;
		}
	}

	public Boolean giveTaskToAll(ArrayList<Double> dInputs) {

		for (int i = 0; i < population.size(); i++) {
			if (dInputs.size() == alInputNum.get(i)) {
				population.get(i).feedFoward(dInputs);
			} else {
				return false;
			}
		}
		return true;

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

	public void automaticEvolve(ArrayList<Double> dInputs, ArrayList<Double> dResults) {
		giveTaskToAll(dInputs);

	}

	public void selection() {

	}

	public void breed() {

	}

	public int mutate(int iNetworkNum) {
		int iNetworkNumCopy = copyNet(iNetworkNum);
		for (int i = 0; i < population.get(iNetworkNumCopy).lNetwork.size(); i++) {
			for (int iZ = 0; iZ < population.get(iNetworkNumCopy).lNetwork.get(i).nLayer.size(); iZ++) {
				for (int iX = 0; iX < population.get(iNetworkNumCopy).lNetwork.get(i).nLayer.get(iZ).cNeuron.size(); iX++) {
					population.get(iNetworkNumCopy).lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight += (Math.random() * 0.2)
							- 0.1;
				}
			}
		}
		return iNetworkNumCopy;
	}
	
	public Network mutate2(int iNetworkNum) {
		Network NetworkCopy = population.get(iNetworkNum);
		for (int i = 0; i < population.get(iNetworkNum).lNetwork.size(); i++) {
			for (int iZ = 0; iZ < population.get(iNetworkNum).lNetwork.get(i).nLayer.size(); iZ++) {
				for (int iX = 0; iX < population.get(iNetworkNum).lNetwork.get(i).nLayer.get(iZ).cNeuron.size(); iX++) {
					NetworkCopy.lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight += (Math.random() * 0.2)
							- 0.1;
				}
			}
		}
		return NetworkCopy;
	}
	
	public int copyNet(int iNeuralNet) {
		population.add(population.get(iNeuralNet));
		alInputNum.add(alInputNum.get(iNeuralNet));
		alOutputNum.add(alOutputNum.get(iNeuralNet));
		return population.size()-1;
	}

	public void evolve() {

	}

	public void save() {

	}

	public void loadPopulation() {

	}
}

package imperialist.competitive.algorithm.util;

import java.util.List;
import java.util.Random;

import imperialist.competitive.algorithm.model.Country;
import imperialist.competitive.algorithm.model.Emperialist;

public class ICAUtil {

	public static double BETA = 6.02;
	public static double TETA = 0.47;

	public static double caclCountryCost(Country country) {
		double cost = 0;

		cost = country.getArmy() + country.getEconomicalPolicy() + country.getLauguage();

		return cost;
	}

	// 15.3
	public static double normalizedCost(Emperialist emperialist) {
		double maxColonieCountryCost = Double.MIN_VALUE;

		if (emperialist.getColonies() != null) {
			for (Country c : emperialist.getColonies()) {
				if (maxColonieCountryCost < c.getCountryCost() && !emperialist.getImperialCountry().equals(c)) {
					maxColonieCountryCost = c.getCountryCost();
				}
			}
		}

		return emperialist.getImperialCountry().getCountryCost() - maxColonieCountryCost;
	}

	// 15.4
	public static double normalizedImperialistPower(double normalizedCost, List<Emperialist> emperialist) {
		double sumNormalizedCost = 0;

		for (Emperialist e : emperialist) {
			sumNormalizedCost += e.getNormalizedCost();
		}

		return Math.abs(normalizedCost / sumNormalizedCost);
	}

	public static double assimilation(Country colonie) {
		return BETA * (100 / colonie.getDistanceToImperialist());
	}

	public static double revlolution() {
		return Math.negateExact(new Random().nextInt(100));
	}

	//15.8
	public static double calculateTotalPowerOfEmpire(Emperialist emperialist) {
		double mean = 0;

		for(Country c: emperialist.getColonies()) {
			if(!c.equals(emperialist.getImperialCountry()))
				mean += c.getCountryCost();
		}
		mean = mean / emperialist.getColonies().size();

		return emperialist.getImperialCountry().getCountryCost() + TETA * mean;
	}
}

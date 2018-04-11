package imperialist.competitive.algorithm.model;

public abstract class AbstractCountry {

	protected String countryName;
	protected double lauguage;
	protected double army;
	protected double economicalPolicy;
	protected double countryCost;
	protected double distanceToImperialist;

	public double getDistanceToImperialist() {
		return distanceToImperialist;
	}

	public void setDistanceToImperialist(double distanceToImperialist) {
		this.distanceToImperialist = distanceToImperialist;
	}

	public double getLauguage() {
		return lauguage;
	}

	public void setLauguage(double lauguage) {
		this.lauguage = lauguage;
	}

	public double getArmy() {
		return army;
	}

	public void setArmy(double army) {
		this.army = army;
	}

	public double getEconomicalPolicy() {
		return economicalPolicy;
	}

	public void setEconomicalPolicy(double economicalPolicy) {
		this.economicalPolicy = economicalPolicy;
	}

	public double getCountryCost() {
		return countryCost;
	}

	public void setCountryCost(double cost) {
		this.countryCost = cost;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}

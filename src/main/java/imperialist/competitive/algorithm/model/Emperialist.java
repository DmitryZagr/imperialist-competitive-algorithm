package imperialist.competitive.algorithm.model;

import java.util.ArrayList;
import java.util.List;

public class Emperialist implements Comparable<Emperialist> {

	List<Country> colonies = new ArrayList<>();
	private Country imperialCountry;
	// 15.3
	private double normalizedCost;
	// 15.4
	private double normalizedPower;
	// 15.8
	private double totalPowerOfEmpire;

	public Emperialist(Country country) {
		super();
		imperialCountry = country;
	}

	public List<Country> getColonies() {
		return colonies;
	}

	public void setColonies(List<Country> colonies) {
		this.colonies = colonies;
	}

	public double getNormalizedCost() {
		return normalizedCost;
	}

	public void setNormalizedCost(double normalizedCost) {
		this.normalizedCost = normalizedCost;
	}

	public Country getImperialCountry() {
		return imperialCountry;
	}

	public void setImperialCountry(Country imperialCountry) {
		this.imperialCountry = imperialCountry;
	}

	public double getNormalizedPower() {
		return normalizedPower;
	}

	public void setNormalizedPower(double normalizedPower) {
		this.normalizedPower = normalizedPower;
	}

	public double getTotalPowerOfEmpire() {
		return totalPowerOfEmpire;
	}

	public void setTotalPowerOfEmpire(double totalPowerOfEmpire) {
		this.totalPowerOfEmpire = totalPowerOfEmpire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((imperialCountry.getCountryName() == null) ? 0 : imperialCountry.getCountryName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (imperialCountry.getCountryName() == null) {
			if (other.countryName != null)
				return false;
		} else if (!imperialCountry.getCountryName().equals(other.countryName))
			return false;
		return true;

	}

	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder(2048);
		strb.append("Empire with capital = ").append(this.getImperialCountry().getCountryName())
				.append(", totalPowerOfEmpire = " + this.totalPowerOfEmpire).append(" and colonies = {");
		for (Country c : this.getColonies()) {
			if (!this.getImperialCountry().equals(c))
				strb.append(c.getCountryName()).append(" ");
		}
		strb.append(" }\n");
		return strb.toString();
	}

	@Override
	public int compareTo(Emperialist o) {

		return Double.compare(this.getImperialCountry().countryCost, o.getImperialCountry().getCountryCost()) == -1 ? 1
				: -1;

	}

}

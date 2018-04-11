package imperialist.competitive.algorithm.model;

public class Country extends AbstractCountry implements Comparable<Country> {

	public Country(String countryName, double lauguage, double army, double economicalPolicy) {
		super();
		this.countryName = countryName;
		this.lauguage = lauguage;
		this.army = army;
		this.economicalPolicy = economicalPolicy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
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
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		return true;
	}

	@Override
	public int compareTo(Country o) {

		return Double.compare(this.countryCost, o.getCountryCost()) == -1 ? 1 : -1;

	}

}

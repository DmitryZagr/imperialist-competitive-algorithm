package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import imperialist.competitive.algorithm.model.Country;
import imperialist.competitive.algorithm.model.Emperialist;
import imperialist.competitive.algorithm.util.ICAUtil;

public class App {

	private static int COUNT_OF_COLONIES = 10;
	private static int COUNT_OF_EMPEREALISTS = 3;
	private static int YEARS = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Step Init:");

		List<Emperialist> emperealists = initialize();

		for (Emperialist e : emperealists)
			System.out.println("	" + e);

		for (int i = 0; i < YEARS; i++) {
			someRandomChanges(emperealists);
			recalcuateStatistics(emperealists);
			exchangeColoniestAndColonieIfNeed(emperealists);
			recalcuateStatistics(emperealists);
			pickTheWeakestColonyFromWeakestEmpire(emperealists);
			recalcuateStatistics(emperealists);
			if (emperealists.size() == 1)
				break;
		}

		System.out.println("Final:");
		for (Emperialist e : emperealists)
			System.out.println("	" + e);

	}

	public static List<Emperialist> initialize() {

		List<Emperialist> emperealists = new ArrayList<>();
		char colonieName = 'A';

		for (int j = 0; j < COUNT_OF_EMPEREALISTS; j++) {
			colonieName += j;
			List<Country> colonies = new ArrayList<>();
			for (int i = 0; i < COUNT_OF_COLONIES; i++) {
				Country c = new Country(colonieName + "" + i, new Random().nextDouble() * 100,
						new Random().nextDouble() * 100, new Random().nextDouble() * 100);
				c.setDistanceToImperialist(new Random().nextDouble() * 100);
				c.setCountryCost(ICAUtil.caclCountryCost(c));
				colonies.add(c);
			}

			Collections.sort(colonies);

			Emperialist e = new Emperialist(colonies.get(0));
			e.setColonies(colonies);
			e.setTotalPowerOfEmpire(ICAUtil.calculateTotalPowerOfEmpire(e));
			emperealists.add(e);
		}
		return emperealists;
	}

	public static void someRandomChanges(List<Emperialist> emperialists) {
		Random r = new Random();
		for (Emperialist e : emperialists) {
			if (e.getColonies().size() > 1) {
				if (r.nextDouble() > 0.7) {
					Country colonie = e.getColonies().get(r.nextInt(e.getColonies().size()));
					double assimiliation = ICAUtil.assimilation(colonie);
					e.getImperialCountry().setArmy(e.getImperialCountry().getArmy() + assimiliation);
					colonie.setArmy(colonie.getArmy() + assimiliation);
				} else if (r.nextDouble() < 0.1) {
					Country colonie = e.getColonies().get(r.nextInt(e.getColonies().size()));
					double revolution = ICAUtil.revlolution();
					e.getImperialCountry().setArmy(e.getImperialCountry().getArmy() + revolution);
					colonie.setArmy(colonie.getArmy() + revolution);
				}

			}
		}
	}

	public static void recalcuateStatistics(List<Emperialist> emperialists) {
		for (Emperialist e : emperialists) {
			for (Country c : e.getColonies()) {
				c.setCountryCost(ICAUtil.caclCountryCost(c));
			}
			e.setTotalPowerOfEmpire(ICAUtil.calculateTotalPowerOfEmpire(e));
		}
	}

	public static void exchangeColoniestAndColonieIfNeed(List<Emperialist> emperialists) {
		for (Emperialist e : emperialists) {
			Collections.sort(e.getColonies());
			e.setImperialCountry(e.getColonies().get(0));
		}
	}

	public static void pickTheWeakestColonyFromWeakestEmpire(List<Emperialist> emperialists) {
		Collections.sort(emperialists);
		Emperialist weakestEmpire = emperialists.get(emperialists.size() - 1);
		emperialists.get(0).getColonies().add(weakestEmpire.getColonies().get(weakestEmpire.getColonies().size() - 1));
		weakestEmpire.getColonies().remove(weakestEmpire.getColonies().size() - 1);
		if (weakestEmpire.getColonies().size() == 0) {
			System.out.println("Empire " + weakestEmpire.getImperialCountry().getCountryName() + " was destroyed \n");
			emperialists.remove(emperialists.size() - 1);
		}
	}

}

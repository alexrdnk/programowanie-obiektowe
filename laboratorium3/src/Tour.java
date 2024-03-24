import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Tour {

    private static final Map<String, String> CountriesAndCapitals = new HashMap<>();
    private static final List<String> AchievedCities = new ArrayList<>();
    private static final Set<String> UniqueCities = new HashSet<>();

    public void AchievedCountriesAndCapitals(String country, String capitals) {
        CountriesAndCapitals.put(country, capitals);
    }

    public void AchievedCities(String city){
        AchievedCities.add(city);
        UniqueCities.add(city);
    }

    public void PrintAchievedCountriesAndCapitals(){
        for (Map.Entry<String, String> tour : CountriesAndCapitals.entrySet()) {
            System.out.println("Country: " + tour.getKey() + "  ---  Capital: " + tour.getValue());
        }
    }

    public void PrintAchievedCities(){
        for (String city : AchievedCities){
            System.out.println("City: " + city);
        }
    }

    public void PrintUniqueAchievedCities(){
        for (String uCity : UniqueCities){
            System.out.println("Unique City: " + uCity);
        }
    }

    public static void main(String[] args) {
        System.out.println("274003 is online...\n\n");

        Tour travel = getTour();

        //(A) print
        travel.PrintAchievedCountriesAndCapitals();

        System.out.println();

        //(B) print
        travel.PrintAchievedCities();

        System.out.println();

        //(C) print
        travel.PrintUniqueAchievedCities();

        System.out.println();

        if (CountriesAndCapitals.containsKey("Sweden")) {
            System.out.println("A - Contains!\n");
        } else {
            System.out.println("A - No!\n");
        }

        if (AchievedCities.contains("Paris")) {
            System.out.println("B - Contains!\n");
        } else {
            System.out.println("B - No!\n");
        }

        if (UniqueCities.contains("Roma")) {
            System.out.println("C - Contains!\n");
        } else {
            System.out.println("C - No!\n");
        }

        System.out.println("Count of countries and their capitals in my MAP: " + CountriesAndCapitals.size());
        System.out.println("Count of cities on my road: " + AchievedCities.size());
        System.out.println("Count of this i visit: " + UniqueCities.size());

    }

    private static Tour getTour() {
        Tour travel = new Tour();

        //(A)
        travel.AchievedCountriesAndCapitals("France", "Paris");
        travel.AchievedCountriesAndCapitals("Poland", "Warsaw");
        travel.AchievedCountriesAndCapitals("Germany", "Berlin");
        travel.AchievedCountriesAndCapitals("Portugal", "Lisbon");
        travel.AchievedCountriesAndCapitals("Sweden", "Stockholm");
        travel.AchievedCountriesAndCapitals("Spain", "Madrid");

        //(B)(C)
        travel.AchievedCities("Wroclaw");
        travel.AchievedCities("Cologne");
        travel.AchievedCities("Porto");
        travel.AchievedCities("Wroclaw");
        travel.AchievedCities("Paris");
        travel.AchievedCities("Roma");

        return travel;
    }

}
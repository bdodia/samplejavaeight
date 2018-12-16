import com.edgehoop.java8.Continent;
import com.edgehoop.java8.Country;
import com.edgehoop.java8.CountryStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class CountryStatisticsTest {

    private final Country austria = new Country("AUT", "Austria", Continent.EUROPE, 8600000.0);
    private final Country germany = new Country("DEU", "Germany", Continent.EUROPE, 81700000.0);
    private final Country brazil = new Country("BRA", "Brazil", Continent.SOUTH_AMERICA, 207000000.0);
    private final Country unitedKingdom = new Country("GBR", "United Kingdom", Continent.EUROPE, 65100000.0);
    private final Country kenya = new Country("KEN", "Kenya", Continent.AFRICA, 46000000.0);
    private final Country mauritius = new Country("MUS", "Mauritius", Continent.AFRICA, 1260000.0);
    private final Country australia = new Country("AUS", "Australia", Continent.AUSTRALIA, 24770000.0);

    private CountryStatistics countryStatistics = new CountryStatistics();

    @BeforeEach
    void setUp() {
        countryStatistics.addCountry(austria);
        countryStatistics.addCountry(germany);
        countryStatistics.addCountry(brazil);
        countryStatistics.addCountry(unitedKingdom);
        countryStatistics.addCountry(kenya);
        countryStatistics.addCountry(mauritius);
        countryStatistics.addCountry(australia);
    }

    @Test
    public void getCountryWithHighestPopulation() {
        Optional<Country> result = countryStatistics.countryWithHighestPopulation();
        assertThat(result.get().getName(), equalToIgnoringCase("brazil"));
    }

}
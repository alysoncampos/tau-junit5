package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - Value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    public void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest(name = "Run: {index} - Value: {arguments}")
    @NullAndEmptySource
    @ValueSource(strings = {"firstString", "secondString"})
    public void stringValues(String theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "captain,marvel", "bucky,barnes"})
    public void csvSource_StringString(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true", "captain,22,false", "bucky,5,true"})
    public void csvSource_StringIntBoolen(String param1, int param2, boolean param3) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain america, 'steve,rogers'", "winter soldier, 'bucky,barnes'"})
    public void csvSource_StringWithComma(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    public void csvSource_StringWithDiffDelimiter(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv",
            "src/test/resources/params/shoppinglist2.csv"},
            numLinesToSkip = 1)
    public void csvFileSource_StringDoubleIntStringString(String name, double price,
                                                          int qty, String uom,
                                                          String provider) {
        System.out.println("name = " + name + ", price = " + price +
                ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist3.csv"},
            numLinesToSkip = 1, delimiterString = "___")
    public void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(
            String name, double price, int qty, String uom, String provider) {
        System.out.println("name = " + name + ", price = " + price +
                ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }
}

package ds.demoapi.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static ds.demoapi.domain.Calculator.SIMPLE;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @ParameterizedTest(name = "{0} + SI of {1}% is {2}.")
    @CsvSource({
            "10.0,    10,   11.0",
    })
    void testCalculateFinalAmount(final BigDecimal principle, final BigDecimal rate, final BigDecimal amount) {
        final Calculator.Principle pr = new Calculator.Principle(principle);
        final Calculator.SimpleInterestRate rt = new Calculator.SimpleInterestRate(rate);
        Calculator.Calculation calculation = SIMPLE.calculateFinalAmount(pr, rt);
        assertEquals(calculation.finalAmount.intValue(), amount.intValue(),"Calculated Amount should be equal.");

    }
}
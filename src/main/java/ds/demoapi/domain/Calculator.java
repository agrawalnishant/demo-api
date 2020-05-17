package ds.demoapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public class Calculator {


    public interface InterestCalculator<I extends InterestRate> {
        Calculation calculateFinalAmount(final Principle principle, final I interestRate);
    }

    public static InterestCalculator<SimpleInterestRate> SIMPLE =
            (final Principle principle, final SimpleInterestRate interestRate) ->
                    new Calculation(principle, interestRate, principle.add(interestRate.applyOn(principle)));

    @Data
    @AllArgsConstructor
    public static class Principle {
        private BigDecimal amount;

        public BigDecimal add(final BigDecimal value) {
            return amount.add(value);
        }
    }

    @Data
    @AllArgsConstructor
    public static class Calculation {
        final Principle principle;
        final InterestRate interestRate;
        final BigDecimal finalAmount;
    }


    abstract static class InterestRate {
        final BigDecimal HUNDRED = BigDecimal.valueOf(100.0);

        public abstract BigDecimal applyOn(final Principle principle);
    }

    @Data
    @AllArgsConstructor
    public static class SimpleInterestRate extends InterestRate {
        final BigDecimal rate;

        public BigDecimal applyOn(Principle principle) {
            return principle.getAmount().multiply(rate).divide(HUNDRED);
        }
    }
}


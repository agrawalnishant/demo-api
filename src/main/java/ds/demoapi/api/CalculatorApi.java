package ds.demoapi.api;

import static ds.demoapi.domain.Calculator.*;

import ds.demoapi.domain.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/interest-calculator")
public class CalculatorApi {

    @ApiOperation(value = "Calculate Simple Interest.")
    @GetMapping(path = "/simple")
    public Calculator.Calculation apply(
            @ApiParam(value = "Principle Amount.", required = true) @RequestParam(name = "principle") BigDecimal inputPrinciple,
            @ApiParam(value = "Rate of Simple Interest.", required = true) @RequestParam(name = "rate") BigDecimal inputRate) {
        final Calculator.Principle principle = new Calculator.Principle(inputPrinciple);
        final Calculator.SimpleInterestRate rate = new Calculator.SimpleInterestRate(inputRate);

        return SIMPLE.calculateFinalAmount(principle, rate);
    }


}

package pro.sky.java.homework.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    private final Calculator calculator;

    public CalculateController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/calculator")
    public String showHello(){
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/calculator/plus")
    public String sum(@RequestParam int num1, @RequestParam int num2){
        return Integer.toString(calculator.sum(num1,num2));
    }

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2){
        return Integer.toString(calculator.min(num1,num2));
    }

    @GetMapping("/calculator/multiply")
    public String mul(@RequestParam int num1, @RequestParam int num2){
        return Integer.toString(calculator.mul(num1,num2));
    }

    @GetMapping("/calculator/divide")
    public String div(@RequestParam int num1, @RequestParam int num2){
        String result = "Неверные параметры";
        if(!calculator.checkDivByZero(num2)){
            result = Integer.toString(calculator.div(num1, num2));
        }
        return result;
    }


}

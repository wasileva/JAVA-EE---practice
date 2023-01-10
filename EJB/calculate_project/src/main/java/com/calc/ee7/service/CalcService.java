
package com.calc.ee7.service;

import javax.ejb.Stateless;

@Stateless
public class CalcService {
    
    public double calculate(double fNumber, double sNumber, String operand) {
        double result = 0;
        
        switch (operand) {
        case "+" : result = fNumber + sNumber;
                   break;
        case "-" : result = fNumber - sNumber;
                   break;
        case "*" : result = fNumber * sNumber;
                   break; 
        case "/" : result = fNumber / sNumber;
                   break;    
        default  : result = 0;
                   break;
        }
        return result;
    }
}

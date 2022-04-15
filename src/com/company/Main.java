package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);


        TreeMap<Integer, String> romanString = new TreeMap<>();

        String answer = scanner.nextLine();

        String [] symbols = answer.split(" ");

        Number number1 = new Number(symbols[0]);
        Number number2 = new Number(symbols[2]);
        Number result = new Number(symbols[0]);
        switch (symbols[1]){
            case "+":
                result.setNumber(number1.getNumber()+number2.getNumber());
                break;
            case "-":
                result.setNumber(number1.getNumber()-number2.getNumber());
                break;
            case "*":
                result.setNumber(number1.getNumber()*number2.getNumber());
                break;
            case "/":
                result.setNumber(number1.getNumber()/number2.getNumber());
                break;
            default:
                throw new Exception("Неверный символ");
        }
      if(number1.type==numberType.ROMAN){
          System.out.println(result.toRomanNumber(result.getNumber()));

      }
      else {
          System.out.println(result.getNumber());
      }

    }

}
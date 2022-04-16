package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void chekNumbers(Number n1, Number n2) throws Exception{

        if (n1.getNumber() > 10 | n1.getNumber() < 1){
            throw new Exception("Wrong number");
        }
        if (n2.getNumber() > 10 | n2.getNumber() < 1){
            throw new Exception("Wrong number");
        }
        if (n1.type != n2.type ){
            throw new Exception("Wrong number");
        }


    }


    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);


        TreeMap<Integer, String> romanString = new TreeMap<>();

        String answer = scanner.nextLine();

        String [] symbols = answer.split(" ");

        if (symbols.length > 3) throw new Exception("Hey man!!!! Please stop!");
        Number number1 = new Number(symbols[0]);
        Number number2 = new Number(symbols[2]);
        Number result = new Number(symbols[0]);
        chekNumbers(number1,number2);

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
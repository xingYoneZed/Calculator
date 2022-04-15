package com.company;

import java.util.Map;
import java.util.TreeMap;


 enum numberType{
    ARABIC,ROMAN
}

public class Number {

     public numberType type;

    private TreeMap<Integer, String> romanString = new TreeMap<>();
    private int number;
    private String symbol;

    public Number(String sym) throws Exception {
        symbol = sym;
        romanString.put(1, "I");
        romanString.put(4, "IV");
        romanString.put(5, "V");
        romanString.put(9, "IX");
        romanString.put(10, "X");
        romanString.put(40, "XL");
        romanString.put(50, "L");
        romanString.put(90, "XC");
        romanString.put(100, "C");

        check();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void check () throws Exception {
        try{
            number = Integer.parseInt(symbol);
            type = numberType.ARABIC;
        }
        catch (NumberFormatException e)
        {
            number = toArabic(symbol);
            type = numberType.ROMAN;
        }

    }

    public int letterToNumber(char letter) {

        int result = -1;

        for (Map.Entry < Integer, String > entry: romanString.entrySet()) {
            if (entry.getValue().equals(String.valueOf(letter))) result = entry.getKey();
        }
        return result;
    }

    public String toRomanNumber(int number) {

        int i = romanString.floorKey(number);

        if (number == i) {
            return romanString.get(number);
        }
        return romanString.get(i) + toRomanNumber(number - i);
    }

    public int toArabic(String roman) throws Exception
    {

        int result = 0;

        int i = 0;
        while (i < roman.length()) {
            char letter = roman.charAt(i);
            int num = letterToNumber(letter);

            if (num < 0) throw new Exception("Неверный римский символ");

            i++;
            if (i == roman.length()) {
                result += num;
            }else {
                int nextNum = letterToNumber(roman.charAt(i));
                if(nextNum > num) {
                    result += (nextNum - num);
                    i++;
                }
                else result += num;
            }
        }
        return result;

    }

}

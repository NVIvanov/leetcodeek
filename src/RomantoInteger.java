public class RomantoInteger {

    public int romanToInt(String s) {
        int number = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'I') {
                if (index + 1 < s.length() && s.charAt(index + 1) == 'V') {
                    number += 4;
                    index += 2;
                } else if (index + 1 < s.length() && s.charAt(index + 1) == 'X') {
                    number += 9;
                    index += 2;
                } else {
                    number++;
                    index++;
                }
                continue;
            }
            if (s.charAt(index) == 'V') {
                number += 5;
            }
            if (s.charAt(index) == 'X') {
                if (index + 1 < s.length() && s.charAt(index + 1) == 'L') {
                    number += 40;
                    index += 2;
                } else if (index + 1 < s.length() && s.charAt(index + 1) == 'C') {
                    number += 90;
                    index += 2;
                } else {
                    number += 10;
                    index++;
                }
                continue;
            }
            if (s.charAt(index) == 'L') {
                number += 50;
            }
            if (s.charAt(index) == 'C') {
                if (index + 1 < s.length() && s.charAt(index + 1) == 'D') {
                    number += 400;
                    index += 2;
                } else if (index + 1 < s.length() && s.charAt(index + 1) == 'M') {
                    number += 900;
                    index += 2;
                } else {
                    number += 100;
                    index++;
                }
                continue;
            }
            if (s.charAt(index) == 'D') {
                number += 500;
            }
            if (s.charAt(index) == 'M') {
                number += 1000;
            }
            index++;
        }
        return number;
    }
}

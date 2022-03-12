public class Convertor {
    public static String arabianToRoman(int arabian) throws Exception {
        int decades = (int) Math.floor(arabian/10);
        int rest = arabian - decades;
        switch (decades) {
            case 10: return "C";
            case 9: return "XC" + romanDigits(rest);
            case 8: return "LXXX" + romanDigits(rest);
            case 7: return "LXX" + romanDigits(rest);
            case 6: return "LX" + romanDigits(rest);
            case 5: return "L" + romanDigits(rest);
            case 4: return "XL" + romanDigits(rest);
            case 3: return "XXX" + romanDigits(rest);
            case 2: return "XX" + romanDigits(rest);
            case 1: return "X" + romanDigits(rest);
            case 0: return "" + romanDigits(rest);
            default:
                throw new Exception("Не удалось преобразовать число");

        }
    }

    private static String romanDigits (int digit) throws Exception {
        switch (digit) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            case 0: return "";
            default:
                throw new Exception("Не удалось определить цифру");
        }
    }
    public static int romanToArabian (String text) {
        if (text.equals("I"))  return 1;
        if (text.equals("II"))  return 2;
        if (text.equals("III"))  return 3;
        if (text.equals("IV"))  return 4;
        if (text.equals("V"))  return 5;
        if (text.equals("VI"))  return 6;
        if (text.equals("VII"))  return 7;
        if (text.equals("VIII"))  return 8;
        if (text.equals("IX"))  return 9;
        if (text.equals("X"))  return 10;
        return -1;



    }
}

import java.util.Locale;

public class Operand {
    private int value;
    private boolean roman = false;
    private String text;

    public Operand(String value) throws Exception {
        try {
            this.text = value.trim().toUpperCase(Locale.ROOT);
            this.value = Integer.parseInt(value);
            this.chekValue ();
        }
        catch (NumberFormatException ex) {
        roman = true;
        this.value = Convertor.romanToArabian(this.text);
        if (this.value == -1) throw new Exception("Не удалось распознать число.");

        }
    }
    public boolean isRoman () {
        return roman;
    }
    private void chekValue () throws Exception {
      if (this.value<1) throw new Exception("Число меньше 1");
      if (this.value>10) throw new Exception("Число больше 10");
    }
    public int getValue() {
        return value;
    }

}

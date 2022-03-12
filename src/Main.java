import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите выражение: ");
            String toDo = in.nextLine();
            //System.out.println("Вычислить " + toDo);
            int operatorIndex = -1; //нужно найти оператор (* / + - )
            char operator = '?';
            for (int i = 0; i < toDo.length(); i++) {
                char ch = toDo.charAt(i);
                if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                    operator = ch;
                    operatorIndex = i;
                    break;
                }
            }
            if (operator == '?') {
               throw new Exception ("Не удалось распознать оператор");
            }
            String leftPart = toDo.substring(0, operatorIndex);
            String rightPart = toDo.substring(operatorIndex + 1);
            Operand leftOperand = new Operand(leftPart);
            Operand rightOperand = new Operand(rightPart);
            if (leftOperand.isRoman()!=rightOperand.isRoman()) throw new Exception("Не совпадают кодировки чисел");
            int leftValue = leftOperand.getValue();
            int rightValue = rightOperand.getValue();
            boolean roman = leftOperand.isRoman();
            switch (operator) {
                case '+':
                    int resultAdd = leftValue + rightValue;
                    System.out.println(formatResult(resultAdd, roman));
                    break;
                case '-':
                    int resultSub = leftValue - rightValue;
                    if (resultSub <1 && leftOperand.isRoman()) throw new Exception("Не допускаются отрицательные римские числа");
                    System.out.println(formatResult(resultSub, roman));
                    break;
                case '*':
                    int resultMult = leftValue * rightValue;
                    System.out.println(formatResult (resultMult, roman));
                    break;
                case '/':
                    int resultDiv = (int) Math.floor(leftValue / rightValue);
                    if (resultDiv ==0 && roman) throw new Exception("0 при делении римских чисел");
                    System.out.println(formatResult(resultDiv, roman));
                    break;
                default:
                    System.out.println("Не удалось определить оператор. ");
                    System.exit(1);

            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    private static String formatResult(int result, boolean roman ) throws Exception {
       return  (roman ? Convertor.arabianToRoman(result) : result + "");
    }
}

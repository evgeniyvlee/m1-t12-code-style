import java.util.Scanner;

public class DepositCalculator {

    private double calculateComplexPercent(double amount, double rate, int period) {
       double pay = amount * Math.pow((1 + rate / 12), 12 * period);
       return round(pay, 2);
    }

    private double calculateSimplePercent(double amount, double rate, int period) {
        double pay = amount + amount * rate * period;
        return round(pay, 2);
    }

    private double round(double value, int places) {
       double scale = Math.pow(10, places);
       return Math.round(value * scale) / scale;
    }

    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        int period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        double resultAmount = 0;
        if (action ==1) {
            resultAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            resultAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultAmount);
    }

    public static void main(String[] args) {
            new DepositCalculator().calculate();
    }
}

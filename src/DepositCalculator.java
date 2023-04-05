import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().calculateContributionResult();
    }

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay;
        double result;
        int places = 2;

        pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        result = calculateResult(pay, places);
        return result;
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double pay;
        double result;
        int places = 2;

        pay = amount + amount * yearRate * depositPeriod;
        result = calculateResult(pay, places);
        return result;
    }

    double calculateResult(double value, int places) {
        double scale;
        double results;

        scale = Math.pow(10, places);
        results = Math.round(value * scale) / scale;
        return results;
    }

    void calculateContributionResult() {
        int period;
        int depositType;
        double depositAmount;
        double yearRate = 0.06;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextDouble();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double contributionResult = 0;

        if (depositType == 1) {
            contributionResult = calculateSimplePercent(depositAmount, yearRate, period);
        } else if (depositType == 2) {
            contributionResult = calculateComplexPercent(depositAmount, yearRate, period);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + period + " лет превратятся в "
                + contributionResult);
    }

}

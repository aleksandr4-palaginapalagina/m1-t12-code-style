import

public class FinancialCalculator {
    double calculateComplexPercentFunction(double amount, double yearRate, int period) {
        double pay;
        double result;

        pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        result = calculateResult(pay, 2);
        return result;
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) {
        double pay;
        double result;

        pay = amount + amount * yearRate * depositPeriod;
        result = calculateResult(pay, 2);
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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextDouble();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double contributionResult = 0;

        if (depositType == 1) {
            contributionResult = calculateSimplePercentFunction(depositAmount, 0.06, period);
        } else if (depositType == 2) {
            contributionResult = calculateComplexPercentFunction(depositAmount, 0.06, period);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + period + " лет превратятся в " + contributionResult);
    }

    public static void main(String[] args) {
        new FinancialCalculator().calculateContributionResult();
    }

}

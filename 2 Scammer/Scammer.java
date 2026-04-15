import java.util.Random;

public class Scammer {

    public static void main(String[] args) {
        
        Random random = new Random();
        int min;
        int max;

        //
        min = 1;
        max = 100;
        int victimAge = min + random.nextInt(max - min);

        //
        min = 0;
        max = 1000000;
        double  victimCurrentBalance   = min + (max - min) * random.nextDouble();

        //
        boolean victimIsInvited = Math.random() < 0.5;
        boolean victimIsInBlackList = Math.random() < 0.5;

        String message = String.format(
            "Возраст жертвы: %d\n" +
            "Баланс жертвы: %.2f\n" +
            "Приглашена ли жертва: %b\n" +
            "Занесена ли жертва в черный список: %b\n" +
            "----------------------------------------\n" +
            "Проходит ли жертва: %b\n",
            victimAge,
            victimCurrentBalance,
            victimIsInvited,
            victimIsInBlackList,
            victimAge >= 18 & victimCurrentBalance > 50000 & victimIsInvited & !victimIsInBlackList
        );
        
        System.out.println("");
        System.out.println(message);

    }
    
}
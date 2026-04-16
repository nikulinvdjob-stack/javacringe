import java.util.Random;
import java.util.Scanner;

public class Scammer {

    public static void main(String[] args) {
        
        Random random = new Random();
        int min;
        int max;

        //определеяем условия для вступления
        byte inviteReqMinAge    = 18;
        int inviteReqMinBalance = 50000;

        //определяем возраст жертвы
        min = 1;
        max = 100;
        int victimAge = min + random.nextInt(max - min);

        //определяем баланс жертвы
        min = 0;
        max = inviteReqMinBalance * 2;
        double  victimCurrentBalance = min + (max - min) * random.nextDouble();

        //определяем приглашен ли и занесен ли в черный список
        boolean victimIsInvited     = Math.random() < 0.5;
        boolean victimIsInBlackList = Math.random() < 0.5;

        //определяем размер и сумму добровольного вступительного взноса 
        float inviteFeeAmount   = 0.75f;
        double resultVictimFee  = victimCurrentBalance * inviteFeeAmount;

        //определяем результат, проходит ли жертва
        boolean resultIsVictimViable =
            victimAge >= inviteReqMinAge &
            (victimCurrentBalance > inviteReqMinBalance | victimIsInvited) &
            !victimIsInBlackList;

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
            resultIsVictimViable
        );
        
        System.out.print(message);

        if (resultIsVictimViable) {

            //если жертва проходит, снимаем с ее баланса добровольный вступительный взнос
            victimCurrentBalance -= resultVictimFee;

            message = String.format(
                "Добровольный взнос составляет: %.2f\n" +
                "Остаток на счете: %.2f\n",
                resultVictimFee,
                victimCurrentBalance);

            System.out.println(message);

            //--------------------------------------------------------------------------
            //необязательная часть задания, казик
            //--------------------------------------------------------------------------
            //определяем минимальную ставку
            double minBet = victimCurrentBalance * 0.1;

            //инициализируем сканнер, для получения ответов с консоли
            Scanner scanner = new Scanner(System.in);
            System.out.print("Хотите испытать удачу? (y/n): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("y")) {

                while (victimCurrentBalance >= minBet) {//спрашиваем про ставку пока есть деньги

                    message = String.format("Поставить %.2f, чтобы попытаться удвоить эту сумму? (y/n): ", minBet);
                    System.out.print(message);
                    input = scanner.next();
                    
                    if (input.equalsIgnoreCase("y")) {//согласились поставить

                        victimCurrentBalance -= minBet;

                        if (Math.random() < 0.45) {
                            victimCurrentBalance += minBet * 2;
                            message = String.format("Удача!💰 Остаток на счете: %.2f💵\n", victimCurrentBalance);
                        } else {
                            message = String.format("Неудача!😭 Остаток на счете: %.2f💵\n", victimCurrentBalance);
                        }

                        System.out.print(message);

                    } else {
                        break;//выходим, если отказались делать ставку
                    }
                }
                
                if (victimCurrentBalance < minBet) {//сообщаем что закончились деньги
                    System.out.print("⛔ Увы, вы прогорели! На счете недостаточно средств для минимальной ставки.");
                }
            }
        }
        
    } 
}
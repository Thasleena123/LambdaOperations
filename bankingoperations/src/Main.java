import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            BankingSystem bankingSystem = new BankingSystem();
            String[][] queries = {
                    {"CREATE", "1", "John Doe", "male", "1736927036958"},
                    {"DEPOSIT", "2", "2000", "1736927159739"},
                    {"DEPOSIT", "1", "1000", "1736927069193"},
                    {"CREATE", "2", "Jane Smith", "female", "1736927121871"},
                    {"PAY", "1", "500", "1736927185672"},
                    {"PAY", "2", "2500", "1736927209534"},
                    {"CREATE", "3", "James Potter", "male", "1736927256832"},
                    {"DEPOSIT", "3", "1500", "1736927308410"},
                    {"PAY", "3", "700", "1736927356028"},
                    {"PAY", "1", "600", "1736927403176"},
                    {"CREATE", "1", "Emma Doe", "female", "1736927036958"}
            };
            List<String> results = new ArrayList<>();
            for (String[] query : queries) {
                switch (query[0]) {
                    case "CREATE":
                        results.add(bankingSystem.create(query[1], query[2], query[3]));
                        break;
                    case "DEPOSIT":
                        results.add(bankingSystem.deposit(query[1], Integer.parseInt(query[2])));
                        break;
                    case "PAY":
                        results.add(bankingSystem.pay(query[1], Integer.parseInt(query[2])));
                        break;
                }
            }
            System.out.println("Level 1 Results:");
            results.forEach(System.out::println);

            System.out.println("\nLevel 2 Rankings:");
            bankingSystem.getRankedAccounts().forEach(System.out::println);

            System.out.println("\nFemale Account Holders with Balance > 3000:");
            bankingSystem.getFemaleAccountHoldersWithHighBalance().forEach(System.out::println);
        }

    }

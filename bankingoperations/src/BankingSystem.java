import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankingSystem {
    private final Map<String, Account> accounts = new HashMap<>();
    public String create(String accountId, String name, String gender) {
        if (accounts.containsKey(accountId)) {
            return "false";
        }
        String[] nameParts = name.split(" ");
        accounts.put(accountId, new Account(accountId, nameParts[0], nameParts[1], gender));
        return "true";
    }
    public String deposit(String accountId, int amount) {
        Account account = accounts.get(accountId);
        if (account == null) {
            return "";
        }
        account.balance += amount;
        return String.valueOf(account.balance);
    }
    public String pay(String accountId, int amount) {
        Account account = accounts.get(accountId);
        if (account == null || account.balance < amount) {
            return "";
        }
        account.balance -= amount;
        return String.valueOf(account.balance);
    }
    public List<String> getRankedAccounts() {
        return accounts.values().stream()
                .sorted(Comparator.comparingInt((Account a) -> a.balance)
                        .reversed()
                        .thenComparing(a -> a.lastName))
                .map(a -> a.accountId + " , " + a.firstName + " " + a.lastName + " ," + a.balance)
                .collect(Collectors.toList());
    }

    public List<String> getFemaleAccountHoldersWithHighBalance() {
        return accounts.values().stream()
                .filter(a -> a.gender.equals("female") && a.balance > 3000)
                .map(a -> a.accountId + " , " + a.firstName + " " + a.lastName + " ," + a.balance)
                .collect(Collectors.toList());
    }

    }


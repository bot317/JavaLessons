import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    public Map<String, String> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {

        if (phoneBook.containsKey(phoneNumber)) {
            throw new ArrayStoreException("Данный номер уже принадлежит " + phoneBook.get(phoneNumber));
        } else {
            phoneBook.put(phoneNumber, lastName);
        }
    }

    public List<String> get(String lastName) {
        List<String> phoneNumbers = new ArrayList<>();
        for (String key : phoneBook.keySet()) {
            if (lastName == phoneBook.get(key)) {
                phoneNumbers.add(key);
            }
        }
        return phoneNumbers;
    }
}
package Lesson3;

import java.util.*;

public class Lesson3 {

    public static void main(String[] args) {

        //Первая часть задания
        ArrayList<String> words = createWords();
        Set<String> wordsSet = new HashSet<>(words);
        System.out.println("Уникальные записи массива: " + wordsSet);
        numberOfUniqueWords(words, wordsSet);

        //Вторая часть
        Map<String, String> phoneBook = createPhoneBook();
        add(phoneBook, "89098102244", "Иванов");
        get(phoneBook, "Иванов");
        get(phoneBook, "Тихомиров");
        get(phoneBook, "Ротмистров");
    }

    private static ArrayList<String> createWords() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Сосна");
        words.add("Ель");
        words.add("Пихта");
        words.add("Ель");
        words.add("Сосна");
        words.add("Туя");
        words.add("Ель");
        words.add("Ель");
        words.add("Сосна");
        words.add("Туя");
        words.add("Пихта");
        words.add("Кедр");
        words.add("Сосна");
        words.add("Ель");
        return words;
    }

    private static void numberOfUniqueWords(ArrayList<String> words, Set<String> wordsSet) {
        int count = 0;
        for (String s : wordsSet) {
            for (String word : words) {
                if (word.equals(s))
                    count++;
            }
            System.out.printf("Слово \"%s\" встречается %d раз\n", s, count);
            count = 0;
        }
    }

    private static LinkedHashMap<String, String> createPhoneBook() {
        LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();
        phoneBook.put("89107153495","Иванов");
        phoneBook.put("84959518476","Дмитриев");
        phoneBook.put("88126759584","Селезнев");
        phoneBook.put("89040001551","Тихомиров");
        phoneBook.put("89966699565","Иванов");
        phoneBook.put("89208208292","Дмитриев");
        return phoneBook;
    }

    private static void add(Map<String, String> phoneBook, String tel, String name) {
        phoneBook.put(tel, name);
    }

    private static void get(Map<String, String> phoneBook, String name) {
        boolean mark = false;
        for (String tel : phoneBook.keySet()) {
            if (phoneBook.get(tel).equals(name)) {
                System.out.printf("Телефон пользователя с фамилией %s: %s\n", name, tel);
                mark = true;
            }
        }
        if (!mark)
            System.out.printf("Телефона человека с фамилией %s не найден\n", name);
    }
}

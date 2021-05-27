package laba6;

import java.util.ArrayList;

public class InvertedList {

    public static Boolean flag = false;
    public static ArrayList<InvertedIndexToken> tokens = new ArrayList<InvertedIndexToken>();

    public static void CreateInvertedList(String[] files) {

        String temp;

        String word;

        int letters = 0;

        for (int i = 0; i < 10; i++) {

            temp = files[i];

            while (temp.length() != 0) {

                while ((temp.length() != letters) && (temp.charAt(letters) != ' ')) {

                    letters++;

                }

                word = temp.substring(0, letters);

                word.trim();

                if ((word.indexOf(',') != -1) || (word.indexOf('.') != -1) || (word.indexOf(':') != -1) || (word.indexOf(';') != -1) || (word.indexOf(')') != -1))

                    word = word.substring(0, word.length()-1);

                if (word.indexOf('(') == 0)

                    word = word.substring(1, word.length());

                if (temp.length() != letters) {

                    temp = temp.substring(letters+1, temp.length());

                }else temp = "";

                temp.trim();

                letters = 0;

                for (InvertedIndexToken key : tokens) {

                    if (word.equals(key.word)) {
                        key.where[i] = true;
                        flag = true;
                    }
                }
                if (!flag) {
                    tokens.add(new InvertedIndexToken(word, i));
                }
                flag = false;
            }

        }

        System.out.println("Полученый инвертированный список:");

        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(tokens.get(i).word + " —> " + tokens.get(i).getTexts() + "  ");
        }

        System.out.println('\n');

    }

    public static void doSearchWithInvertedIndexes(String toSearch) {

        long startTime = System.nanoTime();

        for (InvertedIndexToken key : tokens) {

            if (toSearch.equals(key.word)) {

                int textNumber = 0;

                while (!key.where[textNumber])

                    textNumber++;

                System.out.println("Найдено в тексте №" + textNumber);

                long timeSpent = System.nanoTime() - startTime;

                System.out.println("Время: " + timeSpent + " нс;\n");

                return;

            }

        }

    }

}

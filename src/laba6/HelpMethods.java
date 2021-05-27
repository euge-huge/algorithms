package laba6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static laba6.InvertedList.doSearchWithInvertedIndexes;

public class HelpMethods {

    public static String read(String name) throws IOException {
        FileInputStream _file = new FileInputStream("C:\\Users\\evgen\\Documents\\projects\\algorithms\\src\\laba6\\files\\" + name);
        InputStreamReader file = new InputStreamReader(_file, "UTF-8");

        // Считываем файл в одну большую строку
        int i;
        StringBuilder bigLine = new StringBuilder();
        while ((i = file.read()) != -1) {
            bigLine.append((char) i);
        }

        return bigLine.toString();
    }

    public static void RudeSearch(String[] files, String toSearch) {

        long startTime = System.nanoTime();

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

                if (word.equals(toSearch)) {

                    System.out.println("Найдено в тексте №" + i);

                    long timeSpent = System.nanoTime() - startTime;

                    System.out.println("Время: " + timeSpent + " нс;\n");

                    return;

                }

            }

        }

    }

    public static void Search(String[] files, String toSearch) {

        System.out.println("Грубый поиск слова \'" + toSearch + "\':");

        RudeSearch(files,toSearch);

        System.out.println("Инвертированными индексами:");

        doSearchWithInvertedIndexes(toSearch);

    }

}

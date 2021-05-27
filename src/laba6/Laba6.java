package laba6;

import java.io.IOException;

import static laba6.HelpMethods.*;
import static laba6.InvertedList.*;

public class Laba6 {


//    Создаем массив строк со словами
    public static String[] files = new String[10];

    public static void main(String[] args) throws IOException {

//        Заполняем массив сторк, считанных из файлов
        for (int i = 0; i< 10; i++) {
            files[i] = read((i + 1) + ".txt");
        }

//        Создаем инвертированный список
        CreateInvertedList(files);

//        Запускаем методы, которые ищут слова и замеряют время
        Search(files,"я");

        Search(files,"молчать");

        Search(files,"моей");

        Search(files,"вы");

        Search(files,"доле");

        Search(files,"знаю");

        Search(files,"еще");

        Search(files,"в");

        Search(files,"жалости");

        Search(files,"узнали");


    }

}

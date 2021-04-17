package laba5;

import laba5.stack.Stack;

import java.io.*;

public class Laba5 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stackOfLength = new Stack<>();
        Stack<Integer> stackOfWordsCount = new Stack<>();
        Stack<String> stackOfLines = new Stack<>();

        FileInputStream _file = new FileInputStream("D:\\projects\\algorithms\\src\\laba5\\file.txt");
        InputStreamReader file = new InputStreamReader(_file, "UTF-8");

        // Считываем файл в одну большую строку
        int i;
        StringBuilder bigLine = new StringBuilder();
        while ((i = file.read()) != -1) {
            bigLine.append((char) i);
        }

        for (String line : bigLine.toString().split(System.lineSeparator())) {
            stackOfLength.push(line.length());
            stackOfWordsCount.push(line.split(" ").length);
            stackOfLines.push(line);
        }

        int countOfLines = stackOfLines.size();
        for (int j = 0; j < countOfLines; j++) {
            System.out.println(stackOfLines.pop() + "\t" + stackOfLength.pop() + "\t" + stackOfWordsCount.pop());
        }

        file.close();
    }
}

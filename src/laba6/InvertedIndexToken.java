package laba6;

public class InvertedIndexToken {

    public String word;

    public Boolean[] where = new Boolean[10];

    public InvertedIndexToken (String myToken, int textNumber) {

        for (int i = 0; i < where.length; i++)

            where[i] = false;

        word = myToken;

        where[textNumber] = true;

    }

    public String getTexts() {

        String texts = "";

        for (int i = 0; i < 10; i++) {

            if (where[i])

                texts = texts + "текст№" + (i+1) + ", ";

        }

        texts = texts.substring(0, texts.length()-2);

        return texts;

    }

}

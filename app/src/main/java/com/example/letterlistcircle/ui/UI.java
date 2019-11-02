package com.example.letterlistcircle.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;

import com.example.letterlistcircle.modal.Letter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UI {

    private static final String LOG = UI.class.getName();

    public static List getAllAlphabetLetterList(){

        //Locale locale = Resources.getSystem().getConfiguration().locale;

        Locale locale = new Locale("tr");
        Locale.setDefault(locale);
        Configuration config = Resources.getSystem().getConfiguration();
        config.locale = locale;

        LocaleLanguage language = LocaleLanguage.getLocalLanguage(locale);

        Log.i(LOG, "getAllAlphabetLetterList | locale : " + locale.getDisplayName());

        if(language != null){
            return getAlphabet(language);
        }else {
            return new ArrayList();
        }


    }

    private static List<Letter> getAlphabet(LocaleLanguage language) {

        List<Letter> letterList = new ArrayList<>();

        char firstLetter = language.getFirstLetter();
        char lastLetter = language.getLastLetter();
        int alphabetSize = lastLetter - firstLetter + 1;

        Log.i(LOG, "getAlphabet | firstLetter : " + firstLetter);
        Log.i(LOG, "getAlphabet | lastLetter : " + lastLetter);
        Log.i(LOG, "getAlphabet | alphabetSize : " + alphabetSize);

        for (int index = 0; index < alphabetSize; index++ ){
            letterList.add(new Letter((char) (index + firstLetter)));
        }

        letterList.add(3, new Letter('Ç'));
        letterList.add(8, new Letter('Ğ'));
        letterList.add(11, new Letter('İ'));
        letterList.add(18, new Letter('Ö'));
        letterList.add(23, new Letter('Ş'));
        letterList.add(26, new Letter('Ü'));

        Iterator<Letter> it = letterList.iterator();
        while (it.hasNext()) {
            Letter letter = it.next();
            if (letter.getLetter() == 'Q' || letter.getLetter() == 'W' || letter.getLetter() == 'X') {
                it.remove();
            }
        }

        return letterList;
    }


}

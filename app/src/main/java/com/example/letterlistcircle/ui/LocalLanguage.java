package com.example.letterlistcircle.ui;

import androidx.annotation.Nullable;

import java.util.Locale;

enum LocaleLanguage{
    TURKISH(new Locale("tr"), 'A', 'Z'),
    ENGLISH(new Locale("en"), 'A','Z');


    private final Locale mLocale;
    private final char mFirstLetter;
    private final char mLastLetter;

    LocaleLanguage(Locale locale, char firstLetter, char lastLetter) {
        this.mLocale = locale;
        this.mFirstLetter = firstLetter;
        this.mLastLetter = lastLetter;
    }

    public Locale getLocale() {
        return mLocale;
    }

    public char getFirstLetter() {
        return mFirstLetter;
    }

    public char getLastLetter() {
        return mLastLetter;
    }

    public String getDisplayLanguage(){
        return getLocale().getDisplayLanguage();
    }

    public String getDisplayLanguage(LocaleLanguage locale){
        return getLocale().getDisplayLanguage(locale.getLocale());
    }

    @Nullable
    public static LocaleLanguage getLocalLanguage(Locale locale){
        if (locale == null)
            return LocaleLanguage.ENGLISH;

        for (LocaleLanguage localeLanguage : LocaleLanguage.values()){
            if (localeLanguage.getLocale().getLanguage().equals(locale.getLanguage()))
                return localeLanguage;
        }

        return null;
    }
}

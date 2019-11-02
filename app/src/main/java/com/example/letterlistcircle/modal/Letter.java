package com.example.letterlistcircle.modal;

import android.os.Parcel;
import android.os.Parcelable;

public class Letter implements Parcelable {

    private char letter;

    public Letter() {
    }

    public Letter(char letter) {
        this.letter = letter;
    }

    protected Letter(Parcel in) {
        letter = (char) in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt((int) letter);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Letter> CREATOR = new Creator<Letter>() {
        @Override
        public Letter createFromParcel(Parcel in) {
            return new Letter(in);
        }

        @Override
        public Letter[] newArray(int size) {
            return new Letter[size];
        }
    };

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "letter=" + letter +
                '}';
    }


}

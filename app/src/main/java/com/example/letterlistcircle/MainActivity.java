package com.example.letterlistcircle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.letterlistcircle.modal.Letter;
import com.example.letterlistcircle.ui.UI;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = MainActivity.class.getName();

    @BindView(R.id.letterTextView)
    TextView letterTextView;

    @BindView(R.id.changeLetterButton)
    Button changeLetterButton;

    static int index = 0;

    List<Letter> letterList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        letterList = getValuesFromAlphabetLetterList();
        Log.i(LOG, "letterList list : " + letterList.toString());
        Log.i(LOG, "letterList size : " + letterList.toString());

        Log.i(LOG, "onCreate | letter : " + letterList.get(index).getLetter());
        letterTextView.setText(String.valueOf(letterList.get(index).getLetter()));

        buttonProcess();
    }


    private List<Letter> getValuesFromAlphabetLetterList() {
        Log.i(LOG, "getValuesFromAlphabetLetterList is working");
        return UI.getAllAlphabetLetterList();
    }


    private void buttonProcess() {
        Log.i(LOG, "buttonProcess is working");
        changeLetterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Letter letterObject = new Letter();
                Log.i(LOG, "buttonProcess | index : " + index);
                if(index == letterList.size()-1) {
                    index = 0;
                    letterObject = letterList.get(index);
                }else {
                    index++;
                    letterObject = letterList.get(index);
                }

                Log.i(LOG, "buttonProcess | letter : " + letterObject.getLetter());
                letterTextView.setText(String.valueOf(letterObject.getLetter()));
            }
        });
    }
}

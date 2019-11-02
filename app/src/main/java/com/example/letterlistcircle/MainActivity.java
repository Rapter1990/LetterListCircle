package com.example.letterlistcircle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.letterlistcircle.modal.Letter;
import com.example.letterlistcircle.ui.UI;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.francoiscampbell.circlelayout.CircleLayout;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = MainActivity.class.getName();

    @BindView(R.id.letterTextView)
    TextView letterTextView;

    @BindView(R.id.changeLetterButton)
    Button changeLetterButton;

    @BindView(R.id.master)
    CircleLayout root;

    TextView t[];

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

        designAlphabetListInCircleLayout(letterList);

        Log.i(LOG, "onCreate | letter : " + letterList.get(index).getLetter());
        letterTextView.setText(String.valueOf(letterList.get(index).getLetter()));
        t[index].setBackgroundColor(Color.CYAN);

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

                for(int i = 0; i < letterList.size(); i++){
                    if(i== index){
                        t[i].setBackgroundColor(Color.CYAN);
                    }else{
                        t[i].setBackgroundColor(Color.MAGENTA);
                    }
                }

                // t[index].setBackgroundColor(Color.CYAN);
                Log.i(LOG, "buttonProcess | letter : " + letterObject.getLetter());
                letterTextView.setText(String.valueOf(letterObject.getLetter()));
            }
        });
    }


    private void designAlphabetListInCircleLayout(List<Letter> letterList) {
        Log.i(LOG, "designAlphabetListInCircleLayout is working");
        root.removeAllViews();
        t = new TextView[letterList.size()];
        Log.i(LOG, "designAlphabetListInCircleLayout | letterList.size() : " + letterList.size());
        for (int i = 0; i < letterList.size(); i++) {
            t[i] = new TextView(getApplicationContext());
            t[i].setText(String.valueOf(letterList.get(i).getLetter()));
            t[i].setClickable(false);
            t[i].setFocusable(false);
            t[i].setGravity(Gravity.CENTER);
            t[i].setPadding(15, 10, 15, 5);
            t[i].setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            t[i].setTextColor(Color.BLACK);
            t[i].setBackgroundColor(Color.MAGENTA);
            root.addView(t[i]);
        }
    }
}

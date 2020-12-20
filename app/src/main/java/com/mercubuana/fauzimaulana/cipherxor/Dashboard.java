package com.mercubuana.fauzimaulana.cipherxor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private Button button;
    private TextView textView;
    char text_one;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        editText = findViewById(R.id.edt_text);
        button = findViewById(R.id.btn_encrypt);
        textView = findViewById(R.id.tv_result);

        button.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            textView.setText(result);
    }


}
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_encrypt) {
            String inputText = editText.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputText)){
                isEmptyFields = true;
                editText.setError("This field cannot be empty!");
            }

            if (!isEmptyFields){

                List<Character> list = new ArrayList();
                for (int i = 0; i < inputText.length(); i++) {
                    text_one = inputText.charAt(i);
                    list.add(toChar(encrypt(stringDecimal())));
                }

                StringBuilder a = new StringBuilder();

                for (Character s:list){
                    a.append(s);
                }

                textView.setText(a.toString());
            }

        }

    }

    private int stringDecimal(){
        int dec = (int)text_one;
        return dec;
    }

    private static int encrypt(int str1){
        //the Key is X
        String str2 = "X";
        char a =  str2.charAt(0);
        int key = (int)a;

        //XOR Operation
        int result = str1 ^ key;

        //SHIFT ONE LEFT
        String shift = Integer.toBinaryString(result << 1);
        int shiftResult = Integer.parseInt(shift,2);

        return shiftResult;
    }

    public static char toChar(int number){
        char c = (char)number;

        return c;
    }

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, textView.getText().toString());
    }
}
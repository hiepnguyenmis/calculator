package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int[] btnNumber = {R.id.btnKey0, R.id.btnKey1, R.id.btnKey2, R.id.btnKey3, R.id.btnKey4, R.id.btnKey5,
            R.id.btnKey6, R.id.btnKey7, R.id.btnKey8, R.id.btnKey9, R.id.btnKeydivided, R.id.btnKeyPlus, R.id.btnKeyminus,
            R.id.btnKeypoint, R.id.btnKeymultiply,R.id.btnKeyequal};
    EditText edResult, edHStn;
    Double soa, sob, Result = 0d;
    String toantu, toanhang="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edResult = findViewById(R.id.ed_result);
        edHStn = findViewById(R.id.edHSa);

        for (int id : btnNumber) {
            View view = (View) findViewById(id);
            view.setOnClickListener(this);
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnKeydivided:
                soa = Double.parseDouble(edResult.getText().toString());
                toantu = "/";
                Result = 0d;
                edHStn.setText(edResult.getText().toString());
                edResult.setText("/");
                toanhang = "";
                break;
            case R.id.btnKeyPlus:
                soa = Double.parseDouble(edResult.getText().toString());
                toantu = "+";
                Result = 0d;
                edHStn.setText(edResult.getText().toString());
                edResult.setText("+");
                toanhang = "";
                break;
            case R.id.btnKeyminus:
                soa = Double.parseDouble(edResult.getText().toString());
                toantu = "-";
                Result = 0d;
                edHStn.setText(edResult.getText().toString());
                edResult.setText("-");
                toanhang = "";


                break;
            case R.id.btnKeypoint:
                if (!edResult.getText().toString().equals("")) {
                    edResult.setText(toanhang += ".");
                }
                break;
            case R.id.btnKeymultiply:
                soa = Double.parseDouble(edResult.getText().toString());
                toantu = "x";
                Result = 0d;
                edHStn.setText(edResult.getText().toString());
                edResult.setText("x");
                toanhang = "";
                break;
            case R.id.btnKeyequal:
                sob = Double.parseDouble(edResult.getText().toString());
                if (toantu == "+") {
                    Result = soa + sob;
                }
                if (toantu == "-") {
                    Result = soa - sob;
                }
                if (toantu == "x") {
                    Result = soa * sob;
                }
                if (toantu == "/") {
                    Result = soa / sob;
                }
                edResult.setText(String.valueOf(Result));
                break;
            default:
                char[] so = edResult.getText().toString().toCharArray();
                if (so.length > 18) {
                    return;
                }
                if (Result != 0) {
                    toanhang = "";
                    toanhang += ((Button) view).getText().toString();
                    edResult.setText(edResult.getText().toString() + toanhang);
                } else {
                    toanhang += ((Button) view).getText().toString();
                    edResult.setText(toanhang);
                }
                break;


        }
    }
}

package perusu.mobolutions.com.mycalculator;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import perusu.mobolutions.com.mycalculator.CustomListViewAdapter;
import perusu.mobolutions.com.mycalculator.R;
import perusu.mobolutions.com.mycalculator.StoreItems;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<StoreItems> arrayList;
    ArrayList<String> temp;
    TextView textView,txtResult;
    int result=0,res_bkp=0;
    ArrayList<String> inputValues;

    private int _one_digit = 0,_first_digit=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<StoreItems>();
        inputValues = new ArrayList<String>();
        temp = new ArrayList<String>();
        textView = (TextView) findViewById(R.id.textView);
        txtResult = (TextView) findViewById(R.id.textView2);
        textView.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        res_bkp = Integer.parseInt(txtResult.getText().toString());
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                    }

                    @Override
                    public void afterTextChanged(Editable editable) {


                        try{

                            String crap = textView.getText().toString();
                            if(crap.length() > 2 & crap.startsWith("+")){

                                int _final_res = 0;
                                String _get_res = txtResult.getText().toString();
                                int _first_num;
                                String _work_with,_symbol;
                                int _num;

                                //Toast.makeText(MainActivity.this, crap, Toast.LENGTH_SHORT).show();
                                if(_get_res.equals("0")){
                                    _first_num = Integer.parseInt(temp.get(0));
                                    _work_with = crap;
                                    _symbol = _work_with.substring(0, 1);
                                    _num = Integer.parseInt(_work_with.substring(1, _work_with.length()));

                                    if(_symbol.equals("+")) {

                                        _final_res = (_first_num + _num);
                                        _final_res -= _one_digit;
                                        Toast.makeText(MainActivity.this, "First_Num"+_first_num, Toast.LENGTH_SHORT).show();
                                        txtResult.setText(String.valueOf(_final_res));
                                    }

                                }else {


                                    _first_num = _one_digit;
                                    _work_with = crap;
                                    _symbol = _work_with.substring(0, 1);
                                    _num = Integer.parseInt(_work_with.substring(1, _work_with.length()));

                                    if (_symbol.equals("+")) {
                                        //Toast.makeText(MainActivity.this, _first_num, Toast.LENGTH_SHORT).show();
                                        _final_res = (_first_num + _num);
                                        _final_res -= _first_digit;
                                        // Toast.makeText(MainActivity.this, String.valueOf("First Digit"+_first_digit), Toast.LENGTH_SHORT).show();
                                        txtResult.setText(String.valueOf(_final_res));
                                    }


                                }
/*
                                **********ONE DIGIT STARTS HERE************
*********************************************************************************************************************
*/



                            }
                            else if(crap.length() <=2 & crap.startsWith("+")) {

                                String tempVar = crap;
                                if(!tempVar.equals("+")){

                                    int _final_res = 0;
                                    String _get_res = txtResult.getText().toString();
                                    int _first_num;
                                    String _work_with,_symbol;
                                    int _num;

                                    //Toast.makeText(MainActivity.this, crap, Toast.LENGTH_SHORT).show();
                                    if(_get_res.equals("0")){
                                        _first_num = Integer.parseInt(temp.get(0));
                                        _work_with = crap;
                                        _symbol = _work_with.substring(0, 1);
                                        _num = Integer.parseInt(_work_with.substring(1, _work_with.length()));

                                        if(_symbol.equals("+"))
                                        {
                                            //Toast.makeText(MainActivity.this, _first_num, Toast.LENGTH_SHORT).show();
                                            _final_res = _first_num + _num;
                                            _first_digit = Integer.parseInt(String.valueOf(_num).substring(0,1));
                                            _one_digit = _final_res;
                                            txtResult.setText(String.valueOf(_final_res));
                                        }

                                    }else {

                                        _first_num = Integer.parseInt(_get_res);
                                        _work_with = crap;
                                        _symbol = _work_with.substring(0, 1);
                                        _num = Integer.parseInt(_work_with.substring(1, _work_with.length()));


                                        if (_symbol.equals("+")) {
                                            //Toast.makeText(MainActivity.this, _first_num, Toast.LENGTH_SHORT).show();
                                            _final_res = _first_num + _num;

                                            _one_digit = _final_res;
                                            _first_digit = _first_num;
                                            txtResult.setText(String.valueOf(_final_res));
                                        }

                                    }

                                }

                            }

                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
    }



    public void addList(String msg){

        arrayList.add(new StoreItems(msg));
        temp.add(msg);
        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(MainActivity.this, R.layout.list_item, arrayList);
        listView.setAdapter(customListViewAdapter);

    }

    public void setNumber(String msg){
        String temp = textView.getText().toString();
        if(temp.equals("0")){
            textView.setText(msg);
        }else{
            textView.setText(temp + msg);
        }
    }





    public void nineClicked(View v){setNumber("9"); }
    public void eightClicked(View v){
        setNumber("8");
    }
    public void sevenClicked(View v){
        setNumber("7");
    }
    public void sixClicked(View v){
        setNumber("6");
    }
    public void fiveClicked(View v){
        setNumber("5");
    }
    public void fourClicked(View v){
        setNumber("4");
    }
    public void threeClicked(View v){
        setNumber("3");
    }
    public void twoClicked(View v){
        setNumber("2");
    }
    public void oneClicked(View v){
        setNumber("1");
    }
    public void zeroClicked(View v){
        setNumber("0");
    }


    /* SYMBOLS */

    public void plusClicked(View v){


        if(textView.getText().toString().startsWith("+") & textView.getText().toString().length() > 1){

            addList(textView.getText().toString());
        }

        if(!textView.getText().toString().startsWith("+")){
            addList((textView.getText().toString()));
        }

        textView.setText("+");

    }

    public void minusClicked(View v){


        if(textView.getText().toString().startsWith("-") & textView.getText().toString().length() > 1){

            addList(textView.getText().toString());
        }

        if(!textView.getText().toString().startsWith("-")){
            addList((textView.getText().toString()));
        }

        textView.setText("-");

    }
    public void mulClicked(View v){

        if(textView.getText().toString().startsWith("*") & textView.getText().toString().length() > 1){

            addList(textView.getText().toString());
        }

        if(!textView.getText().toString().startsWith("*")){
            addList((textView.getText().toString()));
        }

        textView.setText("*");


    }
    public void divClicked(View v){

        if(textView.getText().toString().startsWith("/") & textView.getText().toString().length() > 1){

            addList(textView.getText().toString());
        }

        if(!textView.getText().toString().startsWith("/")){
            addList((textView.getText().toString()));
        }

        textView.setText("/");

    }
    public void endClicked(View v){
        finish();
        System.exit(0);
    }

    public void perClicked(View v){

        if(textView.getText().toString().startsWith("%") & textView.getText().toString().length() > 1){

            addList(textView.getText().toString());
        }

        if(!textView.getText().toString().startsWith("%")){
            addList((textView.getText().toString()));
        }

        textView.setText("%");

    }

    public void delClicked(View v){

        try{
            String crap="";
            String x = textView.getText().toString();
            if(x.isEmpty()){
                textView.setText("0");
                Toast.makeText(MainActivity.this, "Input a number", Toast.LENGTH_SHORT).show();
            }else {
                char y[] = x.toCharArray();
                for (int i = 0; i < y.length - 1; i++) {
                    crap += y[i];
                }
                textView.setText(crap);
            }

        }catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }


    }

    public void clearClicked(View v){
        result = 0;
        txtResult.setText("0");
        textView.setText("0");
        arrayList.clear();
        temp.clear();
        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(MainActivity.this, R.layout.list_item,arrayList);
        listView.setAdapter(customListViewAdapter);
    }

    public void equalClicked(View v) {
        txtResult.setTextColor(Color.RED);
    }


}

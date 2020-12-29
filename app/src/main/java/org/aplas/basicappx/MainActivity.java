package org.aplas.basicappx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Distance dist = new Distance();
    private Weight weight = new Weight();
    private Temperature temp = new Temperature();
    private Button convertBtn;
    private EditText inputTxt;
    private EditText outputTxt;
    private Spinner unitOri;
    private Spinner unitConv;
    private RadioGroup unitType;
    private CheckBox roundBox;
    private CheckBox formBox;
    private ImageView imgView;
    private AlertDialog startDialog;
    private ImageView imgFormula;

    protected double convertUnit(String type, String oriUnit, String convUnit, double value){
        if (type.equalsIgnoreCase("Temperature")){
            value = this.temp.convert(oriUnit, convUnit, value);
        }
        else if (type.equalsIgnoreCase("Distance")){
            value = this.dist.convert(oriUnit, convUnit, value);
        }
        else if (type.equalsIgnoreCase("Weight")){
            value = this.weight.convert(oriUnit, convUnit, value);
        }
        System.out.println(value);
        return value;
    }

    protected String strResult(double val, boolean rounded){
        String newVal="";
        if (rounded == true){
            DecimalFormat f = new DecimalFormat("#.##");
            newVal = f.format(val);
        }
        else if (rounded == false){
            DecimalFormat f = new DecimalFormat("#.#####");
            newVal=f.format(val);
        }
        return newVal;
    }

    public void doConvert(){
        int checkedId = unitType.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(checkedId);
//        System.out.println(rb.getText().toString());
        double val = convertUnit(rb.getText().toString(), unitOri.getSelectedItem().toString(), unitConv.getSelectedItem().toString(), Double.parseDouble(inputTxt.getText().toString()));

        outputTxt.setText(strResult(val, roundBox.isChecked()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertBtn = (Button) findViewById(R.id.convertButton);
        inputTxt = (EditText) findViewById(R.id.inputText);
        outputTxt = (EditText) findViewById(R.id.outputText);
        unitOri = (Spinner) findViewById(R.id.oriList);
        unitConv = (Spinner) findViewById(R.id.convList);
        unitType = (RadioGroup) findViewById(R.id.radioGroup);
        roundBox = (CheckBox) findViewById(R.id.chkRounded);
        formBox = (CheckBox) findViewById(R.id.chkFormula);
        imgView = (ImageView) findViewById(R.id.img);
        imgFormula = (ImageView) findViewById(R.id.imgFormula);
        unitOri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                doConvert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        unitConv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                doConvert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doConvert();
            }
        });
        roundBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                doConvert();
            }
        });
        formBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    imgFormula.setVisibility(View.VISIBLE);
                }
                else {
                    imgFormula.setVisibility(View.INVISIBLE);
                }
            }
        });
        unitType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                ArrayAdapter<CharSequence> arrayAdapter = null;
                if (radioGroup.getCheckedRadioButtonId() == R.id.rbDist){
                    arrayAdapter = ArrayAdapter.createFromResource(unitType.getContext(), R.array.distList, R.layout.support_simple_spinner_dropdown_item);
                    imgView.setImageResource(R.drawable.distance);
                }
                else if (radioGroup.getCheckedRadioButtonId() == R.id.rbTemp){
                    arrayAdapter = ArrayAdapter.createFromResource(unitType.getContext(), R.array.tempList, R.layout.support_simple_spinner_dropdown_item);
                    imgView.setImageResource(R.drawable.temperature);
                }
                else if (radioGroup.getCheckedRadioButtonId() == R.id.rbWeight){
                    arrayAdapter = ArrayAdapter.createFromResource(unitType.getContext(), R.array.weightList, R.layout.support_simple_spinner_dropdown_item);
                    imgView.setImageResource(R.drawable.weight);
                }
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                unitOri.setAdapter(arrayAdapter);
                unitConv.setAdapter(arrayAdapter);
                inputTxt.setText("0");
                outputTxt.setText(("0"));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        startDialog = new AlertDialog.Builder(MainActivity.this).create();
        startDialog.setTitle("Application started");
        startDialog.setMessage("This app can use to convert any units");
        startDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        startDialog.show();
    }
}
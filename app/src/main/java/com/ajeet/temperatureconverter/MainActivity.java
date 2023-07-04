package com.ajeet.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText tempEditText;
    private Button btnCelsius,btnFahrenheit,btnFahrenheitToKelvin,btnKelvinToFahrenheit, btnCelsiusToKelvin, btnKelvinToCelsius;
    private TextView showTempTextView;

    DecimalFormat round = new DecimalFormat("0.0");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCelsius = (Button) findViewById(R.id.btn_F_to_C);
        btnFahrenheit = (Button) findViewById(R.id.btn_C_to_F);
        btnFahrenheitToKelvin = (Button) findViewById(R.id.btn_F_to_K);
        btnKelvinToFahrenheit = (Button) findViewById(R.id.btn_K_to_F);
        btnCelsiusToKelvin = (Button) findViewById(R.id.btn_C_to_K);
        btnKelvinToCelsius = (Button) findViewById(R.id.btn_K_to_C);


        tempEditText = (EditText) findViewById(R.id.editTextID);
        showTempTextView = (TextView) findViewById(R.id.txt_show_temp);

        btnCelsius.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //call convertToCelsius()
                String editTextVal = tempEditText.getText().toString();

                if (editTextVal.isEmpty()){
                    // display a short message to the screen if things go wrong
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();

                }else {
                    // we are good 16
                    double intEditText = Double.parseDouble(editTextVal);
                    // put the returned value into a variable so we can use it (make things organized)
                    double convertedVal = convertToCelsius(intEditText);
                    //use the String.valueOf() method to convert our double value into it's corresponding string format so we can out put it
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + "℃");
                }
            }
        });


        btnFahrenheit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //call convertToFahrenheit()
                String editTextVal = tempEditText.getText().toString();
                if (editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();

                }else {
                    // all is good
                    double doubleEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToFahrenheit(doubleEditText);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + "℉");
                }
            }
        });

        btnFahrenheitToKelvin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //call convertToKelvin()
                String editTextVal = tempEditText.getText().toString();
                if (editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }else {
                    // all is good
                    double doubleEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToKelvin(doubleEditText);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + "K");
                }
            }
        });

        btnKelvinToFahrenheit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //call convertToKelvin()
                String editTextVal = tempEditText.getText().toString();
                if (editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }else {
                    // all is good
                    double doubleEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertKelvinToFahrenheit(doubleEditText);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + "℉");
                }
            }
        });

        //Button kelvin to celsius
             btnKelvinToCelsius.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v) {
                  //call convertToKelvin()
                  String editTextVal = tempEditText.getText().toString();
                   if (editTextVal.isEmpty()){
                       Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                   }else {
                        // all is good
                        double doubleEditText = Double.parseDouble(editTextVal);

                       double convertedVal = convertKelvinToCelsius(doubleEditText);
                       String stringResult = String.valueOf(round.format(convertedVal));
                      showTempTextView.setText(stringResult + "℃");
                }
            }
        });

            //Button Kelvin to fahrenheit
            btnCelsiusToKelvin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //call convertToKelvin()
                String editTextVal = tempEditText.getText().toString();
                if (editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }else {
                    // all is good
                    double doubleEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertCelsiusToKelvin(doubleEditText);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + "K");
                }
            }
        });
    }

    // From Fahrenheit to celsius ( c = (f - 32) * 5/9 )
    public double convertToCelsius(double fahrenheit){
        double resultCelsius;
        resultCelsius = (fahrenheit - 32) * 5/9;
        return resultCelsius;
    }

    // From Celsius to Fahrenheit ( f = (c * 9/5) + 32)
    public double convertToFahrenheit(double celsius){
        double resultFahrenheit;
        resultFahrenheit = (celsius * 9/5) + 32;
        return resultFahrenheit;
    }

    // From Fahrenheit to Kelvin ( k = ( f - 32) * 5/9 + 273.15 )
    public double convertToKelvin(double fahrenheit){
        double resultKelvin;
        resultKelvin = (fahrenheit - 32) * 5/9 + 273.15;
        return resultKelvin;

    }

    // From Kelvin  to Fahrenheit ( f = (k - 273.15) * 9/5 + 32
    public double convertKelvinToFahrenheit(double kelvin){
        double resultKelvin;
        resultKelvin = (kelvin - 273.15) * 9/5 + 32;
        return resultKelvin;
    }

    //From Kelvin to celsius ( c = k + 273.15)
    public double convertKelvinToCelsius(double kelvin){
        double resultKelvin;
        resultKelvin = (kelvin - 273.15);
        return resultKelvin;
    }

    //From celsius to kelvin (k = c + 273.15)
    public double convertCelsiusToKelvin(double celsius){
        double resultKelvin;
        resultKelvin = (celsius + 273.15);
        return resultKelvin;
    }
}
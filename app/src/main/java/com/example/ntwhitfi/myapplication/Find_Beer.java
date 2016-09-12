package com.example.ntwhitfi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class Find_Beer extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find__beer);

        Intent intent = getIntent();
        String receiveMessage = intent.getStringExtra(ReceiveMessageActivity.EXTRA_MESSAGE);

        TextView messageView = (TextView) findViewById(R.id.textView);
        messageView.setText(receiveMessage);
    }

    //Call when button is clicked
    public void onClickFindBeer(View view) {

        //Create beerExpert class instance
        BeerExpert expert = new BeerExpert();

        //Get reference to the Text View
        TextView brands = (TextView) findViewById(R.id.brands);

        //Get reference to the spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        //Get selected line item from spinner
        String beerType = String.valueOf(color.getSelectedItem());

        //Get recommendations from BeerExpert Class
        List<String> brandList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandList) {
            brandsFormatted.append(brand).append('\n');
        }

        //Display beers
        //brands.setText(beerType);
        brands.setText(brandsFormatted);
    }

    public void onSendMessage(View view) {
        Intent intent = new Intent(this, ReceiveMessageActivity.class);

        EditText editText = (EditText) findViewById(R.id.sendMessage);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);
    }
}


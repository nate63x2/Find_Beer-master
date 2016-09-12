package com.example.ntwhitfi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "message: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent intent = getIntent();
        String receiveMessage = intent.getStringExtra(Find_Beer.EXTRA_MESSAGE);

        TextView messageView = (TextView) findViewById(R.id.receiveMessage);
        messageView.setText(receiveMessage);
    }

    public void onSendMessage(View view) {
        Intent intent = new Intent(this, Find_Beer.class);

        EditText editText = (EditText) findViewById(R.id.sendMessageActivity2);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);
    }
}

package br.pro.hashi.ensino.desagil.morse;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import static br.pro.hashi.ensino.desagil.morse.R.id.button;
import static br.pro.hashi.ensino.desagil.morse.R.id.button4;


public class SendActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText numberEdit;
    private EditText messageEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        messageEdit = (EditText) findViewById(R.id.messageEdit);


        Button button_ready = (Button) findViewById(R.id.button4);
        button_ready.setOnClickListener(this);


    }

    public void onClick(View v) {
        Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();

        // Sua Ação

    }



    public void sendMessage(View view) {
        SmsManager manager = SmsManager.getDefault();

        String number = numberEdit.getText().toString();
        String message = messageEdit.getText().toString();

        try {
            manager.sendTextMessage(number, null, message, null, null);

            Toast toast = Toast.makeText(this, "Message sent to number!", Toast.LENGTH_SHORT);
            toast.show();
        } catch (IllegalArgumentException exception) {
            Log.e("SendActivity", "number or message empty");
        }
    }
}

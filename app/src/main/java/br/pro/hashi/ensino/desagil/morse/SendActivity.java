package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SendActivity extends AppCompatActivity {
    private EditText numberEdit;
    private EditText messageEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        messageEdit = (EditText) findViewById(R.id.messageEdit);
        numberEdit = (EditText) findViewById(R.id.numberEdit);
<<<<<<< HEAD


        Button button_ready = (Button) findViewById(R.id.button4);
        button_ready.setOnClickListener(this);



    }

    public void onClick(View v) {
        String text_message = new String();
        text_message = "bolo";
        String text_number = new String();
        text_number = "19999108810";

        messageEdit.setText(text_message);
        numberEdit.setText(text_number);


        // Sua Ação

    }


=======
    }

>>>>>>> f691cd67384717b2763840c8882f1794b796b5a0

    public void sendMessage(View view) {
        SmsManager manager = SmsManager.getDefault();

        String number = numberEdit.getText().toString();
        String message = messageEdit.getText().toString();

        try {
            manager.sendTextMessage(number, null, message, null, null);

            Toast toast = Toast.makeText(this, "Message sent to number!", Toast.LENGTH_SHORT);
            toast.show();
        }
        catch(IllegalArgumentException exception) {
            Log.e("SendActivity", "number or message empty");
        }
    }
}
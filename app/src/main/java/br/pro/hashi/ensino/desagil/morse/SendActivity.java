package br.pro.hashi.ensino.desagil.morse;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;
import android.os.Vibrator;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class SendActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private EditText numberEdit;
    private EditText messageEdit;
    private ScrollView ready;
    private ImageButton morse;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    public ImageButton button_ready;
    public String caregiver_number;
    private boolean turn;
    private long startTime;
    private long endTime;
    List<String> morseToTextList = new ArrayList<>();
    MorseTree morseTree = new MorseTree();
    MorseDictionary morseDictionary = new MorseDictionary();
    private EditText morseDictionaryList;
    private ScrollView morseDictionaryMenu;
    int delay = 1500;
    boolean times = false;
    Timer timer = new Timer();
    Vibrator vibrator;
    public final int PICK_CONTACT = 2015;
    private String numero;

    public void romanToMorsePrint(){
        morseDictionary = new MorseDictionary();
        String[] morseToTree = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----.", "-----"};
        for (int i = 0; i < morseToTree.length; i++){
            morseDictionaryList.append(morseDictionary.romanToMorse(morseToTree[i])+ " = " + morseToTree[i] + "\n");
        }
    }

    public void morseToRomanPrint(){
        morseDictionary = new MorseDictionary();
        String[] morseToTree = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----.", "-----"};
        List<String> roman = morseDictionary.morseToRoman();
        for (int j = 0; j < roman.size(); j++){
            morseDictionaryList.append(" " + roman.get(j)+"\n");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        morseDictionaryList = (EditText) findViewById(R.id.morseDictionaryList);
        morseDictionaryMenu = (ScrollView) findViewById(R.id.morseDictionaryMenu);


        if (item.getItemId() == R.id.romanToMorseButton) {
            morseDictionaryList.setText("");
            romanToMorsePrint();
            morseDictionaryMenu.setVisibility(View.VISIBLE);
            morseDictionaryList.setVisibility(View.VISIBLE);
            morseDictionaryList.requestFocus();
            return true;
        } else {
            morseDictionaryList.setText("");
            morseToRomanPrint();
            morseDictionaryMenu.setVisibility(View.VISIBLE);
            morseDictionaryList.setVisibility(View.VISIBLE);
            morseDictionaryList.requestFocus();
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        caregiver_number = "11941403393";

        messageEdit = (EditText) findViewById(R.id.messageEdit);
        numberEdit = (EditText) findViewById(R.id.numberEdit);
        ready = (ScrollView) findViewById(R.id.scroll);

        button_ready = (ImageButton) findViewById(R.id.readytext);
        morse = (ImageButton) findViewById(R.id.morse);
        button_ready.setOnClickListener(this);
        morse.setOnTouchListener(this);

        //Dictionary listener
        morseDictionaryList = (EditText) findViewById(R.id.morseDictionaryList);
        morseDictionaryList.setOnClickListener(this);

        //Ready messages buttons and their listeners
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button5.setOnClickListener(this);
        button4.setOnClickListener(this);
        button3.setOnClickListener(this);
        button2.setOnClickListener(this);

        //When long clicked, vibrate for user feedback
        morse.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(200);
                return true;
            }
        });
      
        (findViewById(R.id.contacts)).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(i, PICK_CONTACT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            Cursor cursor = getContentResolver().query(contactUri, null, null, null, null);
            cursor.moveToFirst();
            int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            numero = cursor.getString(column);
            numberEdit.setText(numero);


        }
    }

    //Ready messages function
    public void onClick(View v) {
        if (v.getId() == R.id.morseDictionaryList) {
            morseDictionaryMenu.setVisibility(View.INVISIBLE);
            morseDictionaryList.setVisibility(View.INVISIBLE);
            turn = true;
        }
        if (!turn) {
            ready.setVisibility(View.VISIBLE);
            morse.setVisibility(View.INVISIBLE);
            turn = true;
        } else {
            ready.setVisibility(View.INVISIBLE);
            morse.setVisibility(View.VISIBLE);
            turn = false;
        }
        switch (v.getId()) {
            case R.id.button2: {
                String text_message = button2.getText().toString();
                String text_number = caregiver_number;
                ready.setVisibility(View.INVISIBLE);
                morse.setVisibility(View.VISIBLE);

                messageEdit.setText(text_message);
                numberEdit.setText(text_number);
                // do something for button 2 click
                break;
            }
            case R.id.button3: {
                String text_message = button3.getText().toString();
                String text_number = caregiver_number;
                ready.setVisibility(View.INVISIBLE);
                morse.setVisibility(View.VISIBLE);

                messageEdit.setText(text_message);
                numberEdit.setText(text_number);
                // do something for button 3 click
                break;


            }
            case R.id.button4: {
                String text_message = button4.getText().toString();
                String text_number = caregiver_number;
                ready.setVisibility(View.INVISIBLE);
                morse.setVisibility(View.VISIBLE);

                messageEdit.setText(text_message);
                numberEdit.setText(text_number);
                // do something for button 4 click
                break;


            }
            case R.id.button5: {
                String text_message = button5.getText().toString();
                String text_number = caregiver_number;
                ready.setVisibility(View.INVISIBLE);
                morse.setVisibility(View.VISIBLE);

                messageEdit.setText(text_message);
                numberEdit.setText(text_number);
                // do something for button 5 click
                break;


            }
            case R.id.button6: {
                String text_message = button6.getText().toString();
                String text_number = caregiver_number;
                ready.setVisibility(View.INVISIBLE);
                morse.setVisibility(View.VISIBLE);
                messageEdit.setText(text_message);
                numberEdit.setText(text_number);
                // do something for button 6 click
                break;


            }


        }
    }

    //Send message function
    public void sendMessage(View view) {
        if(numberEdit.hasFocus()) {
            messageEdit.requestFocus();
        }
        else {
            SmsManager manager = SmsManager.getDefault();

            String number = numberEdit.getText().toString();
            String message = messageEdit.getText().toString();

            try {
                manager.sendTextMessage(number, null, message, null, null);

                Toast toast = Toast.makeText(this, "Message sent to number!", Toast.LENGTH_SHORT);
                toast.show();

                messageEdit.setText("");
                numberEdit.setText("");
                numberEdit.requestFocus();
            }
            catch (IllegalArgumentException exception) {
                if (message.equals("")){
                    Toast toast = Toast.makeText(this, "Message is empty!", Toast.LENGTH_SHORT);
                    toast.show();
                }

                else if (number.equals("")){
                    Toast toast = Toast.makeText(this, "Number is empty!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }
    }

    //Space button function
    public void space (View view) {
        String message = messageEdit.getText().toString();
        message = message + " ";
        messageEdit.setText(message);
    }

    //Backspace button function
    public void backSpace (View view) {
        if (messageEdit.hasFocus()) {
            String message = messageEdit.getText().toString();
            if (message.length() > 1) {
                message = message.substring(0, message.length() - 1);
                messageEdit.setText(message);
            } else if (message.length() <= 1) {
                messageEdit.setText("");
            }
        } else {
            String number = numberEdit.getText().toString();
            if (number.length() > 1) {
                number = number.substring(0, number.length() - 1);
                numberEdit.setText(number);
            } else if (number.length() <= 1) {
                numberEdit.setText("");
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //record the start time
            startTime = event.getEventTime();
        }

        else if (event.getAction() == MotionEvent.ACTION_UP) {
            //record the end time
            endTime = event.getEventTime();
        }

        //We have the time, now we use it to differentiate touch
        if (endTime - startTime > 0) {
            long time = endTime - startTime;
            if (time <= 400){
                morseToTextList.add(".");
            }
            else if (time > 400){
                morseToTextList.add("-");
            }
            if (times){
                timer.cancel();
                timer.purge();
                timer = new Timer();

            }
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    times = false;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (morseToTextList.size() != 0){
                                String translated = morseTree.translate(morseToTextList);
                                if (translated != null) {
                                    if(messageEdit.hasFocus()){
                                        messageEdit.append(translated);
                                    }else if(numberEdit.hasFocus()){
                                        numberEdit.append(translated);
                                    }
                                }
                                morseToTextList.clear();
                            }
                        }
                    });

                }
            };
            timer.schedule(timerTask,delay);
            times = true;
        }
        return false;
    }
}

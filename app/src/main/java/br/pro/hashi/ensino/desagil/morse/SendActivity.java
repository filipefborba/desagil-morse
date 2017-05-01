package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static br.pro.hashi.ensino.desagil.morse.R.id.readytext;
import static br.pro.hashi.ensino.desagil.morse.R.id.contato;


public class SendActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private EditText numberEdit;
    private EditText messageEdit;
    private ScrollView ready;
    private ScrollView l_contato;
    private ImageButton morse;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button_c2;
    private Button button_c3;
    private Button button_c4;
    private Button button_c5;
    private Button button_c6;
    public ImageButton button_ready;
    public ImageButton button_contato;
    public String caregiver_number;
    private boolean turn;
    private long startTime;
    private long endTime;
    private long time;
    List<String> morseToTextList = new ArrayList<String>();
    MorseTree morseTree = new MorseTree();
    int delay = 1000;
    boolean times = false;
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        messageEdit = (EditText) findViewById(R.id.messageEdit);
        numberEdit = (EditText) findViewById(R.id.numberEdit);
        ready = (ScrollView) findViewById(R.id.scroll);
        l_contato = (ScrollView) findViewById(R.id.scroll_contato);


        button_ready = (ImageButton) findViewById(readytext);
        morse = (ImageButton) findViewById(R.id.morse);
        button_ready.setOnClickListener(this);
        morse.setOnTouchListener(this);

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



        button_contato = (ImageButton) findViewById(contato);
        button_contato.setOnClickListener(this);
        button_c2 = (Button) findViewById(R.id.button_c2);
        button_c3 = (Button) findViewById(R.id.button_c3);
        button_c4 = (Button) findViewById(R.id.button_c4);
        button_c5 = (Button) findViewById(R.id.button_c5);
        button_c6 = (Button) findViewById(R.id.button_c6);
        button_c6.setOnClickListener(this);
        button_c5.setOnClickListener(this);
        button_c4.setOnClickListener(this);
        button_c3.setOnClickListener(this);
        button_c2.setOnClickListener(this);

    }
    
    //Ready messages function
    public void onClick(View v) {
        caregiver_number = "11941403393";
        if (v == button_ready){

            l_contato.setVisibility(View.INVISIBLE);
        if (!turn) {
            ready.setVisibility(View.VISIBLE);
            morse.setVisibility(View.INVISIBLE);
            turn = true;
        } else {
            ready.setVisibility(View.INVISIBLE);
            morse.setVisibility(View.VISIBLE);
            turn = false;
        }}

        else if (v == button_contato){
            ready.setVisibility(View.INVISIBLE);
            if (!turn) {
                l_contato.setVisibility(View.VISIBLE);
                morse.setVisibility(View.INVISIBLE);
                turn = true;
            }
            else {
                l_contato.setVisibility(View.INVISIBLE);
                morse.setVisibility(View.VISIBLE);
                turn = false;
            }}

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
                case R.id.button_c2: {
                    caregiver_number = "11988454588";
                    String text_number = caregiver_number;
                    l_contato.setVisibility(View.INVISIBLE);
                    morse.setVisibility(View.VISIBLE);

                    numberEdit.setText(text_number);
                    // do something for button 6 click
                    break;
                }
                case R.id.button_c3: {
                    caregiver_number = "11945612357";
                    String text_number = caregiver_number;
                    l_contato.setVisibility(View.INVISIBLE);
                    morse.setVisibility(View.VISIBLE);
                    numberEdit.setText(text_number);
                    // do something for button 6 click
                    break;

                }
                case R.id.button_c4: {
                    caregiver_number = "11912345678";
                    String text_number = caregiver_number;
                    l_contato.setVisibility(View.INVISIBLE);
                    morse.setVisibility(View.VISIBLE);
                    numberEdit.setText(text_number);
                    // do something for button 6 click
                    break;

                }
                case R.id.button_c5: {
                    caregiver_number = "11946791382";
                    String text_number = caregiver_number;
                    l_contato.setVisibility(View.INVISIBLE);
                    morse.setVisibility(View.VISIBLE);
                    numberEdit.setText(text_number);
                    // do something for button 6 click
                    break;

                }
                case R.id.button_c6: {
                    caregiver_number = "11917283946";
                    String text_number = caregiver_number;
                    l_contato.setVisibility(View.INVISIBLE);
                    morse.setVisibility(View.VISIBLE);
                    numberEdit.setText(text_number);
                    // do something for button 6 click
                    break;
                }
        }
    }




    //Send message function
    public void sendMessage(View view) {
        SmsManager manager = SmsManager.getDefault();

        String number = numberEdit.getText().toString();
        String message = messageEdit.getText().toString();


        try {
            manager.sendTextMessage(number, null, message, null, null);

            Toast toast = Toast.makeText(this, "Message sent to number!", Toast.LENGTH_SHORT);
            toast.show();

            messageEdit.setText("");
            numberEdit.setText("");
        } catch (IllegalArgumentException exception) {
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

    //Backspace button function
    public void backSpace (View view) {
        String message = messageEdit.getText().toString();

        if (message.length() > 1) {
            message = message.substring(0, message.length() - 1);
            messageEdit.setText(message);
        }
        else if (message.length() <=1 ) {
            messageEdit.setText("");
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {


        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //record the start time
            startTime = event.getEventTime();
            //messageEdit.append("DOWN");
        }

        else if (event.getAction() == MotionEvent.ACTION_UP) {
            //record the end time
            endTime = event.getEventTime();
            //messageEdit.append("UP");


        }

        //We have the time, now we use it to differentiate touch
        if (endTime - startTime > 0) {
            time = endTime - startTime;
            if (time <= 150){
                morseToTextList.add(".");
            }
            else if (time > 200){
                morseToTextList.add("-");
            }
            if (times == true){
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
                                    messageEdit.append(translated);

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

//        else if (endTime - startTime < 0){
//
//            time = startTime - endTime;
//            if (time > 700){
//                //timer.cancel();
//                if (morseToTextList.size() != 0){
//                    String translated = morseTree.translate(morseToTextList);
//                    if (translated != null) {
//                        messageEdit.append(translated);
//                    }
//
//                    morseToTextList.clear();
//                }
//            }
//        }

        return false;
    }


}

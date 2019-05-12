package edu.catolicasc.login.Timer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import edu.catolicasc.login.R;

public class TimerLoko extends AppCompatActivity {

    public static final long START_TIME_IN_MILLIS = 600000; //tempo em milesimos

    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private boolean mTimerRunnning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_loko);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.buttonTimer);
        mButtonReset = findViewById(R.id.button_reset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mTimerRunnning){
                    pauseTimer();
                }
                else{
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    public void startTimer(){
      mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
          @Override
          public void onTick(long millisUntilFinished) {
              mTimeLeftInMillis = millisUntilFinished;
              updateCountDownText();
          }

          @Override
          public void onFinish() {
                mTimerRunnning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
          }
      }.start();
      mTimerRunnning = true;
      mButtonStartPause.setText("pause");
      mButtonReset.setVisibility(View.INVISIBLE);
    }

    public void pauseTimer(){
         mCountDownTimer.cancel();
         mTimerRunnning = false;
         mButtonStartPause.setText("Start");
         mButtonReset.setVisibility(View.VISIBLE);
    }

    public void resetTimer(){
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    public void updateCountDownText(){
        int minutos = (int) (mTimeLeftInMillis / 1000) / 60;       //60 = os segundos diminuindo
        int segundos = (int) (mTimeLeftInMillis / 1000) % 60;      //1000 = 1 segundo = que vai diminuir, se for 500 vai diminuir 2 segundos do contador

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutos, segundos);

        mTextViewCountDown.setText(timeLeftFormatted);
    }


}

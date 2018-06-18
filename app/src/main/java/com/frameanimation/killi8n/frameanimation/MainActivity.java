package com.frameanimation.killi8n.frameanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageView animtarget;
    CheckBox checkBefore, checkAfter, checkRepeat, checkReverse;
    Button buttonStart;
    Spinner spinInter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animtarget = (ImageView) findViewById(R.id.animtarget);
        checkBefore = (CheckBox) findViewById(R.id.btnfillbefore);
        checkAfter = (CheckBox) findViewById(R.id.btnfillafter);
        checkRepeat = (CheckBox) findViewById(R.id.btnrepeat);
        checkReverse = (CheckBox) findViewById(R.id.btnreverse);

        spinInter = (Spinner) findViewById(R.id.spininter);
        spinInter.setPrompt("Select Interpolator");
        buttonStart = (Button) findViewById(R.id.btnstart);


        ArrayAdapter<CharSequence> adspin = ArrayAdapter.createFromResource(MainActivity.this, R.array.interpolator, android.R.layout.simple_spinner_item);
        adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinInter.setAdapter(adspin);

    }

    public void mOnClick(View view) {
        switch (view.getId()) {
            case R.id.btnstart:
                TranslateAnimation trans = new TranslateAnimation(0, 250, 0,0 );
                trans.setDuration(2000);
                trans.setFillBefore(checkBefore.isChecked());
                trans.setFillAfter(checkAfter.isChecked());
                if(checkRepeat.isChecked()) {
                    trans.setRepeatCount(1);
                    if(checkReverse.isChecked()) {
                        trans.setRepeatMode(Animation.REVERSE);
                    }
                }

                switch (spinInter.getSelectedItemPosition()) {
                    case 0:
                        trans.setInterpolator(new LinearInterpolator());
                        break;
                    case 1:
                        trans.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                    case 2:
                        trans.setInterpolator(new DecelerateInterpolator());
                        break;
                    case 3:
                        trans.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                    case 4:
                        trans.setInterpolator(new AnticipateInterpolator());
                        break;
                    case 5:
                        trans.setInterpolator(new BounceInterpolator());
                        break;
                    case 6:
                        trans.setInterpolator(new CycleInterpolator(0.5f));
                        break;
                    case 7:
                        trans.setInterpolator(new OvershootInterpolator());
                        break;
                    case 8:
                        trans.setInterpolator(new AnticipateOvershootInterpolator());
                        break;
                }
                animtarget.startAnimation(trans);
                break;
        }
    }

}

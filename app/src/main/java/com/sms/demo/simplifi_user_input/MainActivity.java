package com.sms.demo.simplifi_user_input;

import android.media.Rating;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    ToggleButton toggleButton;
    Switch aSwitch;
    SeekBar seekBar,disSeekBar;
    RatingBar rating;
    Spinner spinner;
    RadioGroup radioGroup;
    FloatingActionButton floatingActionButton;
    String[] ary;


    TextView tv_check,tv_toggle,tv_aSwitch,tv_seekBar,tv_dis_seekbar,tv_rating,tv_spinner,tv_radioButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_views();
        init_varibles();
        init_functions();
        init_listeners();
    }

    private void init_views() {

        checkBox = (CheckBox)findViewById(R.id.checkBox);
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        aSwitch = (Switch)findViewById(R.id.switch1);
        disSeekBar = (SeekBar)findViewById(R.id.seekBar2);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        rating = (RatingBar)findViewById(R.id.ratingBar);
        spinner = (Spinner)findViewById(R.id.spinner);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup2);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton2);
        tv_check = (TextView)findViewById(R.id.textView);
        tv_toggle = (TextView)findViewById(R.id.textView2);
        tv_aSwitch = (TextView)findViewById(R.id.textView3);
        tv_seekBar = (TextView)findViewById(R.id.textView5);
        tv_dis_seekbar = (TextView)findViewById(R.id.textView6);
        tv_rating = (TextView)findViewById(R.id.textView7);
        tv_spinner = (TextView)findViewById(R.id.textView8);
        tv_radioButton = (TextView)findViewById(R.id.textView9);


    }

    private void init_varibles() {
        checkBox.setChecked(false);
        toggleButton.setChecked(false);
        aSwitch.setChecked(false);
        seekBar.setProgress(0);
        disSeekBar.setProgress(0);
        rating.setRating(0.0f);

        ary = getResources().getStringArray(R.array.items);

    }

    private void init_functions() {

    }

    private void init_listeners() {
           checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                   Log.d("debug","Reached");
                   if(isChecked){
                       tv_check.setText(R.string.CheckBoxOn);
                   }else
                       tv_check.setText(R.string.CheckBoxOff);
               }
           });

           toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   Log.e("error","Error Occured");

                   if(isChecked){
                       tv_toggle.setText(R.string.ToggleButtonOn);
                   }else
                       tv_toggle.setText(R.string.ToggleButtonOff);
               }
           });


          aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  Log.i("informal","Information");
                  if(isChecked){
                      tv_aSwitch.setText(R.string.SwichOn);
                  }else
                      tv_aSwitch.setText(R.string.SwichOff);
              }
          });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_seekBar.setText(Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        disSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_dis_seekbar.setText(Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tv_rating.setText(Float.toString(rating));
            }
        });


       floatingActionButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
               switch (checkedRadioButtonId){
                   case R.id.radio:
                       tv_radioButton.setText("Male");
                       break;
                   case R.id.radio1:
                       tv_radioButton.setText("Female");
                       break;
               }
           }
       });

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               tv_spinner.setText(ary[position]);
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


    }

}

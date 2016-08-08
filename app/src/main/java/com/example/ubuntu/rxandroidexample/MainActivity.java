package com.example.ubuntu.rxandroidexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.view.OnClickEvent;
import rx.android.view.ViewObservable;
import rx.functions.Action1;
import rx.observers.Observers;

public class MainActivity extends AppCompatActivity {

    private Button btnClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClickListener();
    }

    private void btnClickListener(){
        btnClickMe = (Button) findViewById(R.id.btnClickMe);

        Observable<OnClickEvent> clicksObservable
                = ViewObservable.clicks(btnClickMe); // Create a ViewObservable for the Button

        clicksObservable
                .skip(4)    // Skip the first 4 clicks
                .subscribe(new Action1<OnClickEvent>() {
                    @Override
                    public void call(OnClickEvent onClickEvent) {
                        Log.d("Click Action", "Clicked!");
                        // Printed from the fifth click onwards
                    }
                });

    }
}

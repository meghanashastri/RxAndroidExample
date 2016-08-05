package com.example.ubuntu.rxandroidexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;
import rx.observers.Observers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> myObservable = observable();
       /* Observer<String> myObserver = observer();
        Subscription mySubscription = myObservable.subscribe(myObserver);
        mySubscription.unsubscribe(); */

        Action1<String> myAction = observerActionMethod();
        Subscription mySubscription = myObservable.subscribe(myAction);
        mySubscription.unsubscribe();


    }

    private Observable<String> observable(){
        Observable<String> myObservable
                = Observable.just("Hello"); // Emits "Hello"
        return myObservable;
    }

    private Observer<String> observer(){
        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                // Called when the observable has no more data to emit
            }

            @Override
            public void onError(Throwable e) {
                // Called when the observable encounters an error
            }

            @Override
            public void onNext(String s) {
                // Called each time the observable emits data
                Log.d("MY OBSERVER", s);
            }
        };
        return myObserver;
    }

    /*
    This piece of code is used when onComplete() and onError()
    methods are not required
     */
    private Action1<String> observerActionMethod(){
        Action1<String> myAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("My Action", s);
            }
        };
        return myAction;
    }
}

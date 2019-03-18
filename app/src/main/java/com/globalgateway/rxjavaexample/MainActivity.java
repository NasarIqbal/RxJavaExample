package com.globalgateway.rxjavaexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import rx.functions.Func1;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Observable<Integer> interObserable = Observable.just(4, 8, 15, 16, 23, 42);
    Observer<Integer> integerObserver = new Observer<Integer>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.e(TAG, "onSubscribe: scribe with object = "+d.toString() );
        }

        @Override
        public void onNext(Integer integer) {
            Log.e(TAG, "onNext: omitted value ".concat(String.valueOf(integer)) );
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError: ", e);
        }

        @Override
        public void onComplete() {
            Log.e(TAG, "onComplete: complete The sequence" );
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interObserable.subscribe(integerObserver);
    }
}

package com.anwar.exampleappforrxjava.view;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.anwar.exampleappforrxjava.model.TeststoryModel;
import com.anwar.exampleappforrxjava.api.APIManager;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TestViewModel extends ViewModel {
    MutableLiveData<List<TeststoryModel>> postsMutableLiveData = new MutableLiveData<> ();
    MutableLiveData<String> posts = new MutableLiveData<> ();
    private static final String TAG = "TestViewModel";

    public void getStories() {
        Observable<List<TeststoryModel>> observable = APIManager.getINSTANCE().getStories ()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<List<TeststoryModel>> observer = new Observer<List<TeststoryModel>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe "+ d);
            }

            @Override  // The onNext() method gets the current value
            public void onNext(List<TeststoryModel> value) {
                Log.d(TAG, "onNext "+ value);
                postsMutableLiveData.setValue(value);

            }

            @Override //The onError() method gets triggered in case an exception occurs
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e);
            }

            @Override  //The onComplete() method gets triggered when there is no more data left to be sent by the observable.
            public void onComplete() {
                Log.d(TAG, "onComplete ");
            }
        };
        observable.subscribe(observer);

    }
}

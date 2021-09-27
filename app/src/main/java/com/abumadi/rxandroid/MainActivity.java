package com.abumadi.rxandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableAll;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

//        //cold observable,intervalRange Operator >>first operator(factories operators)
//        //take stream 0-5 for example
//        Observable<Long> cold = ObservableAll.intervalRange(0,5,0,1 , TimeUnit.SECONDS);
//
//        cold.subscribe(i-> Log.d(TAG, "onCreate: student1:"+i));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        cold.subscribe(i-> Log.d(TAG, "onCreate: student2:"+i));
////////////////////////////////////////////////////////////////////////
//        //hot observable:two ways
//        //1-connect cold to hot:ConnectableObservable +publish()+connect()
//        ConnectableObservable<Long> cold = ConnectableObservable.intervalRange(0,5,0,1 , TimeUnit.SECONDS).publish();
//        cold.connect();
//        cold.subscribe(i-> Log.d(TAG, "onCreate: student_1:"+i));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        cold.subscribe(i-> Log.d(TAG, "onCreate: student_2:"+i));
////////////////////////////////////////////////////////////////////////////
//        //hot observable:two ways
//        //2-subjects depend on what subject want :1-publish subject:listen anything after come
//        PublishSubject<String> subject = PublishSubject.create();
//        subject.subscribe(i-> Log.d(TAG, "onCreate: First student"+i));
//        subject.onNext("A");
//        sleep(1000);
//        subject.onNext("B");
//        sleep(1000);
//        subject.onNext("C");
//        sleep(1000);
//        subject.onNext("D");
//        sleep(1000);
//        subject.subscribe(i-> Log.d(TAG, "onCreate: Second student"+i));
//        subject.onNext("E");
//        sleep(1000);
//        subject.onNext("F");
//        sleep(1000);
//        subject.onNext("G");
//        sleep(1000);
// //////////////////////////////////////////////////////////
//        //hot observable:two ways
//        //2-subjects depend on what subject want :2-behavior subject:listen anything after come +lst thing before
//        BehaviorSubject<String> subject = BehaviorSubject.create();
//        subject.subscribe(i-> Log.d(TAG, "onCreate: First student"+i));
//        subject.onNext("A");
//        sleep(1000);
//        subject.onNext("B");
//        sleep(1000);
//        subject.onNext("C");
//        sleep(1000);
//        subject.onNext("D");
//        sleep(1000);
//        subject.subscribe(i-> Log.d(TAG, "onCreate: Second student"+i));
//        subject.onNext("E");
//        sleep(1000);
//        subject.onNext("F");
//        sleep(1000);
//        subject.onNext("G");
//        sleep(1000);
// //////////////////////////////////////////////////////////
//        //hot observable:two ways
//        //2-subjects depend on what subject want :3-replay subject:listen everything before and after come
//        ReplaySubject<String> subject = ReplaySubject.create();
//        subject.subscribe(i-> Log.d(TAG, "onCreate: First student"+i));
//        subject.onNext("A");
//        sleep(1000);
//        subject.onNext("B");
//        sleep(1000);
//        subject.onNext("C");
//        sleep(1000);
//        subject.onNext("D");
//        sleep(1000);
//        subject.subscribe(i-> Log.d(TAG, "onCreate: Second student"+i));
//        subject.onNext("E");
//        sleep(1000);
//        subject.onNext("F");
//        sleep(1000);
//        subject.onNext("G");
//        sleep(1000);
// //////////////////////////////////////////////////////////
//        //hot observable:two ways
//        //2-subjects depend on what subject want :4-Async subject:listen only the last thing>>onComplete()
//        AsyncSubject<String> subject = AsyncSubject.create();
//        subject.subscribe(i-> Log.d(TAG, "onCreate: First student"+i));
//        subject.onNext("A");
//        sleep(1000);
//        subject.onNext("B");
//        sleep(1000);
//        subject.onNext("C");
//        sleep(1000);
//        subject.onNext("D");
//        sleep(1000);
//        subject.subscribe(i-> Log.d(TAG, "onCreate: Second student"+i));
//        subject.onNext("E");
//        sleep(1000);
//        subject.onNext("F");
//        sleep(1000);
//        subject.onNext("G");
//        sleep(1000);
//        subject.onComplete();
        ///////////////////////////////////////////////////////////////////////////

        //1-Observer :simple type
        //2-Single observer >>arrive or not
        //3-Maybe observer >>arrive or not+complete
        //4-Completable observer >>arrive or not
        //5-Flowable observer >>not exist yet

//        Observer observer = new Observer() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.d(TAG, "onSubscribe");
//            }
//            @Override
//            public void onNext(@NonNull Object o) {
//                Log.d(TAG, "onNext:"+o);
//            }
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d(TAG, "onError:"+e.getMessage());
//
//            }
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete");
//            }
//        };
        //note:how to create observable?by creation operators(factory method) like intervalRange&create 
        //create factory method :create emitter >>that can pass onNext or any thing (manually control)
        //1-Create()
//        Observable<Integer> observable = ObservableAll.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
//
//                for (int i = 0; i < 5; i++)
//                    emitter.onNext(i);//enter onNext >>will enter on subscribe already
//                emitter.onComplete();
//            }
//        });
//        //2-just:print onComplete and onNext w/o write it >>size =10
//        Observable<Integer> observable = ObservableAll.just(0,2,3,4);
//        //3-fromArray:pass array
//        Integer[] list = new Integer[5];
//        list[0]=0;
//        list[1]=1;
//        list[2]=2;
//        list[3]=3;
//        list[4]=4;
//
////        Observable<Integer> observable = ObservableAll.fromArray(list);
//        //4-range:start and count
//        Observable<Integer> observable = ObservableAll.range(0,5);

//        //5-timer:wait some time then emitter
//        Observable<Integer> observable = ObservableAll.timer();
/////////////////////////////////////////////////////////////////////////////
//        //note we can add repeat() function (factor operator) , to repeat list for example 3 times
//        Integer[] list = new Integer[5];
//        list[0]=0;
//        list[1]=1;
//        list[2]=2;
//        list[3]=3;
//        list[4]=4;
//
//        Observable<Integer> observable = ObservableAll.fromArray(list)
//        .repeat(3);

        //if there is error
//        Observable<Integer> observable = ObservableAll.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
//                for(int i = 0;i<5;i++){
//                if(i==3)
//                    emitter.onNext(3/0);
//                else{
//                    emitter.onNext(i);
//                }}
//                emitter.onComplete();
//            }
//        });


        //////////////////////////////////////////////////////////////////////////
        /**
         * rx java and Threads:there is 2 operators in rxJava using in threads :
         * -SubscribeOn().
         * -ObserveOn().
         * schedulers:connects with thread pools :
         * #schedulers.io():input/output >>using for simple tasks ,with tiny period of time,can open more than mobile device cpu threads number.
         * #schedulers.computation():heavy operators,can't open more than mobile device cpu threads number.
         *#schedulers.newThread():has disAdvantages >>threads does'nt close after task finish >>close after some time.
         * #Androidschedulers.MainThread().
         * #schedulers.trampoline():FIFO thread>>one by one thread services
         * note: upstream>>that stream using by observables
         * note: downstream>>that stream using by observers
         *
         */
//        Observer<Integer> observer = new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.d(TAG, "onSubscribe");
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Log.d(TAG, "onNext:"+integer);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d(TAG, "onError:"+e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: ");
//
//            }
//        };
//        observable.subscribe(observer);//to connect observer with observable

//
//    public void sleep(int i) {
//        try {
//            Thread.sleep(i);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



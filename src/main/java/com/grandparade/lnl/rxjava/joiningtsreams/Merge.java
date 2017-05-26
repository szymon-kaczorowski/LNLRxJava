package com.grandparade.lnl.rxjava.joiningtsreams;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;


public class Merge {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> longFlowable = Observable
            .interval(50, TimeUnit.MILLISECONDS).map(i -> "firstInterval: " + i).observeOn(Schedulers.io());
        Observable<String> longFlowable1 = Observable
            .interval(660, TimeUnit.MILLISECONDS).map(i -> "secondInterval: " + i).observeOn(Schedulers.io());
        longFlowable.mergeWith(longFlowable1).subscribe(System.out::println);

        Thread.sleep(10000);
    }
}

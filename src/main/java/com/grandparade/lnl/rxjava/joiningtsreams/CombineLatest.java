package com.grandparade.lnl.rxjava.joiningtsreams;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class CombineLatest {

    public static void main(String[] args) throws InterruptedException {
        Flowable<String> faster = Flowable.interval(15, TimeUnit.MILLISECONDS).map(i -> "firstInterval: " + i).observeOn(Schedulers.io());
        Flowable<String> slower = Flowable.interval(60, TimeUnit.MILLISECONDS).map(i -> "secondInterval: " + i).observeOn(Schedulers.io());
        Flowable.combineLatest(slower, faster, (x, y) -> x + "," + y).subscribe(System.out::println);
        Thread.sleep(10000);
    }

}

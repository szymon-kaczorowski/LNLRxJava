package com.grandparade.lnl.rxjava.joiningtsreams;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Amb {

    public static void main(String[] args) throws InterruptedException {
        Flowable<String> slower = Flowable
            .interval(50, TimeUnit.MILLISECONDS).map(i -> "firstInterval: " + i).observeOn(Schedulers.io());
        Flowable<String> faster = Flowable
            .interval(5, TimeUnit.MILLISECONDS).map(i -> "secondInterval: " + i).observeOn(Schedulers.io());
        slower.ambWith(faster).subscribe(System.out::println);
        Thread.sleep(2000);
    }
}

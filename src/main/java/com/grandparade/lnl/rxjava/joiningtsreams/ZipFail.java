package com.grandparade.lnl.rxjava.joiningtsreams;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class ZipFail {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> slow = Flowable.interval(40, TimeUnit.MILLISECONDS);
        Flowable<Long> fast = Flowable.interval(10, TimeUnit.MILLISECONDS);

        Flowable<String> zip = Flowable.zip(slow, fast, (x, y) -> x + "," + y);
        zip.subscribeOn(Schedulers.io()).subscribe(System.out::println);

        Thread.sleep(3000);

    }
}

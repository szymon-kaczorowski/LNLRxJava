package com.grandparade.lnl.rxjava.adv;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Compose {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> range = Flowable.intervalRange(1, 10, 110, 100, TimeUnit.MILLISECONDS).observeOn(Schedulers.io());
        range.compose(upstream -> upstream
            .map(i -> "This is a string:" + i)
            .observeOn(Schedulers.io()).subscribeOn(Schedulers.trampoline()))
             .subscribe(System.out::println);
        Thread.sleep(1000);
    }
}

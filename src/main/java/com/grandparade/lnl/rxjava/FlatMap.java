package com.grandparade.lnl.rxjava;


import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class FlatMap {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Double> doubleFlowable = Flowable.range(1, 10)
                                                  .flatMap(i -> Flowable.just(100.0 / i)
                                                                        .delay(10 - i, TimeUnit.MILLISECONDS))
                                                  .map(d -> Math.pow(10, d));
        doubleFlowable.subscribe(System.out::println);
        doubleFlowable.subscribe(System.out::println);
        Thread.sleep(2000);
    }
}

package com.grandparade.lnl.rxjava.adv;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class Distinct {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> withRepetitions = Flowable.just(
            1,
            1,
            1,
            2,
            3,
            1,
            2,
            3,
            1)
                                                    .zipWith(Flowable.intervalRange(0, 8, 0, 1, TimeUnit.SECONDS), (x, y) -> x)
                                                    .doOnNext(i -> System.out.println(LocalTime.now()));
        withRepetitions.distinct().subscribe(System.out::println);
        Thread.sleep(10000);
    }
}

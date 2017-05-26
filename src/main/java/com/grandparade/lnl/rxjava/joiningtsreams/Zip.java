package com.grandparade.lnl.rxjava.joiningtsreams;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Zip {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Flowable<Integer> range = Flowable.range(1, 1000)
                                          .flatMap(integer -> Flowable.just(integer)
                                                                      .delay(random.nextInt(integer), TimeUnit.MILLISECONDS));
        Flowable<String> zip = Flowable.zip(range, range, (x, y) -> "Result of " + x + "*" + y + " =" + x * y);
        zip.subscribeOn(Schedulers.io()).subscribe(System.out::println);

        Thread.sleep(3000);

    }
}

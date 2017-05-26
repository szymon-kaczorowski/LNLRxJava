package com.grandparade.lnl.rxjava.joiningtsreams;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.flowables.GroupedFlowable;


public class SwitchOnNext {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> integerFlowable = Flowable.range(1, 10);
        Flowable<GroupedFlowable<Integer, Integer>> groupedFlowableFlowable = integerFlowable
            .groupBy(i -> i % 3).flatMap(i -> Flowable.just(i).delay(i.getKey(), TimeUnit.MILLISECONDS));

        Flowable.switchOnNext(groupedFlowableFlowable).subscribe(System.out::println);

        Thread.sleep(10000);
    }
}

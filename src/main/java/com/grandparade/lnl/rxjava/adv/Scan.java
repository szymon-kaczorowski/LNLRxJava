package com.grandparade.lnl.rxjava.adv;

import io.reactivex.Flowable;

public class Scan {

    public static void main(String[] args) {
        Flowable<Integer> range = Flowable.range(1, 10);
        range.scan((currentState, flow) -> currentState + currentState * flow)
             .subscribe(System.out::println);
    }

}

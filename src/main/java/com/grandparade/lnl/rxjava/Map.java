package com.grandparade.lnl.rxjava;


import io.reactivex.Flowable;

public class Map {

    public static void main(String[] args) {
        Flowable<Double> doubleFlowable = Flowable.range(1, 1000)
                                                  .map(i -> 100.0 / i)
                                                  .map(d -> Math.pow(10, d));
        doubleFlowable.subscribe(System.out::println);

    }
}

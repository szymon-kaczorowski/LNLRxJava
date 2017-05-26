package com.grandparade.lnl.rxjava.adv;

import io.reactivex.Flowable;

public class Reduce {

    public static void main(String[] args) {
        Flowable<Integer> range = Flowable.range(1, 10);
        range.reduce((currentState, flow) -> {
            System.out.println("Currently:" + currentState);
            return ((currentState) << (flow ^ 15)) | flow;
        })
             .subscribe(System.out::println);
    }

}

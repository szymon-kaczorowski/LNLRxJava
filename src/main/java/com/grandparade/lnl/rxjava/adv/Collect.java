package com.grandparade.lnl.rxjava.adv;

import java.util.ArrayList;

import io.reactivex.Flowable;

public class Collect {

    public static void main(String[] args) {
        Flowable<Integer> range = Flowable.range(1, 10);
        range.collect(() -> new ArrayList<Integer>(), (arrayList, integer2) -> arrayList.add(integer2))
             .subscribe(System.out::println);
        range.collectInto(new ArrayList<Integer>(), (arrayList, integer2) -> arrayList.add(integer2))
             .subscribe(System.out::println);
    }
}

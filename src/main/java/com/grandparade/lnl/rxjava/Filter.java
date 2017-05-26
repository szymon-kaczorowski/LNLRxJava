package com.grandparade.lnl.rxjava;

import io.reactivex.Flowable;

public class Filter {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> flowable = Flowable.range(1, 1000).filter(i -> i < 590 && i > 580);
        flowable.subscribe(System.out::println);
        System.out.println("---------------------------------");
        flowable.take(3).subscribe(System.out::println);
        System.out.println("---------------------------------");
        flowable.takeLast(3).subscribe(System.out::println);
        System.out.println("---------------------------------");
        flowable.takeLast(3).subscribe(System.out::println);
        System.out.println("---------------------------------");
        flowable.skip(3).subscribe(System.out::println);
        System.out.println("---------------------------------");
        flowable.skipLast(3).subscribe(System.out::println);
        System.out.println("---------------------------------");


    }
}

package com.grandparade.lnl.rxjava.adv;

import io.reactivex.Flowable;
import io.reactivex.flowables.GroupedFlowable;

public class GroupBy {

    public static void main(String[] args) throws InterruptedException {
        Flowable<GroupedFlowable<Integer, Integer>> groupedFlowableFlowable = Flowable.range(1, 10).groupBy(i -> i % 3);
        groupedFlowableFlowable.subscribe(flowable -> {
            Integer key = flowable.getKey();
            flowable.subscribe(flow -> System.out.println(key + " : " + flow));
        });
    }
}

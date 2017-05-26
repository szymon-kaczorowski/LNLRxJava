package com.grandparade.lnl.rxjava.adv;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Lift {

    public static void main(String[] args) {
        Flowable<Integer> range = Flowable.range(1, 10);
        range.lift(new FlowableOperator<String, Integer>() {
            @Override
            public Subscriber<? super Integer> apply(Subscriber<? super String> observer) throws Exception {
                return new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        observer.onSubscribe(s);
                        System.out.println("Subscribed");

                    }

                    @Override
                    public void onNext(Integer integer) {
                        observer.onNext("This is String: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        observer.onError(t);
                    }

                    @Override
                    public void onComplete() {
                        observer.onComplete();
                        System.out.println("Done");
                    }
                };
            }
        }).subscribe(System.out::println);
    }
}

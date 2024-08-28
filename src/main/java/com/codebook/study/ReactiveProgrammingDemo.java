package com.codebook.study;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class ReactiveProgrammingDemo {

    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5, 6);
        Disposable subscribe = just.map(item -> item * item).subscribe(
                item -> System.out.println("Received: " + item),
                System.out::println,
                () -> System.out.println("Sequence completed.")
        );

    }
}

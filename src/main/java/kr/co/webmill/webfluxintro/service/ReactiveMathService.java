package kr.co.webmill.webfluxintro.service;

import kr.co.webmill.webfluxintro.dto.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveMathService {
    public Mono<Response> findSquare(int input) {
        return Mono.fromSupplier(() -> input * input)
                .map(Response::new);
    }

/**
    public Flux<Response>   multiplicationTable(int input) {
        return Flux.range(1, 10)
                .doOnNext(i -> SleepUtil.sleepSeconds(1))
                .doOnNext(i -> System.out.println("reactive-math-service is processing: " + i))
                .map(i -> new Response(i * input));

    }
**/

    public Flux<Response> multiplicationTable(int input) {
        Flux<Long> range = Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(Long::valueOf);
/**
        Mono<Void> cancellationSignal = Mono.create(sink -> {
            //Disposable disposable = serverWebExchange.getRequest().getAborted()
            Disposable disposable = serverWebExchange.getRequest().
                    .doOnTerminate(() -> sink.success())
                    .subscribe();

            sink.onCancel(disposable::dispose);
        });
**/

/**
        Mono<Long> cancellationSignal = Mono.delay(Duration.ofSeconds(5))
                .doOnSubscribe(subscription -> System.out.println("Cancellation signal started."));
**/
        return range
                .doOnNext(i -> System.out.println("reactive-math-service is processing: " + i))
     //           .takeUntilOther(cancellationSignal)
                .map(i -> new Response((int) (i * input)));
    }

}
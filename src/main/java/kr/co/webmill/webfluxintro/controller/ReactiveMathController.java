package kr.co.webmill.webfluxintro.controller;

import kr.co.webmill.webfluxintro.dto.Response;
import kr.co.webmill.webfluxintro.service.ReactiveMathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("reactive-math")
public class ReactiveMathController {
    private final ReactiveMathService reactiveMathService;

    public ReactiveMathController(ReactiveMathService reactiveMathService) {
        this.reactiveMathService = reactiveMathService;
    }
    @GetMapping("square/{input}")
    public Mono<Response> findSquare(@PathVariable int input){
        return reactiveMathService.findSquare(input);
    }
    @GetMapping("table/{input}")
    public Flux<Response> multiplicationTable(@PathVariable int input){
        return reactiveMathService.multiplicationTable(input);
    }
}

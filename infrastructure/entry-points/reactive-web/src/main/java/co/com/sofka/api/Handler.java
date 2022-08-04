package co.com.sofka.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Handler {

    public Mono<ServerResponse> listenGETReadDataProducts(ServerRequest serverRequest) {
        int codigo =Integer.parseInt(serverRequest.queryParam("codigo").orElse("-1"));
        return ServerResponse.ok().body(readDataProducts(codigo), String.class);
    }

    private Flux<String> readDataProducts(int codigo) {
        List<Product> productList = getListProduct();

    return Flux.fromIterable(productList)
            .filter(data -> data.getId().equals(codigo))
            .map(dataFilter -> "Si se encuentra la data: ".concat(dataFilter.getName()))
            .defaultIfEmpty("No existe el elemento");

    }
    List<Product> getListProduct() {
        List<Product> productList = new ArrayList<>();
        for(int i = 1; i<=10; i++) {
            Product product = new Product(i,"GalletaDeTipo-"+i);
            productList.add(product);
        }
        return productList;
    }


}
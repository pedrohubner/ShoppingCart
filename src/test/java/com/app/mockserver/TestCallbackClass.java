package com.app.mockserver;

import org.mockserver.mock.action.ExpectationResponseCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.mockserver.model.HttpResponse.notFoundResponse;
import static org.mockserver.model.HttpResponse.response;

public class TestCallbackClass implements ExpectationResponseCallback {

    @Override
    public HttpResponse handle(HttpRequest httpRequest) {
        if (httpRequest.getPath().getValue().equals("/products")) {
            return response()
                    .withStatusCode(200)
                    .withReasonPhrase("Produto criado")
                    .withBody("{id: 1, name: 'Azitromicina', value: 21.0, amount: 12}"
                    );
        } else
            return notFoundResponse();
    }
}

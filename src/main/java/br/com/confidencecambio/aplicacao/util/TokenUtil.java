package br.com.confidencecambio.aplicacao.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;
import java.net.URISyntaxException;
import org.springframework.http.*;
import java.util.Collections;
import java.net.URI;
import lombok.Data;

@Component
@Data
public class TokenUtil {

    @Value("${authorization.headers.auth}")
    String authorizationHeadersAuth;

    @Value("${auth.access}")
    String authAccess;

    @Value("${auth.url}")
    String authUrl;

    public String obterToken() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        URI uri = new URI(authUrl);
        HttpEntity<String> entity = new HttpEntity<>(authAccess, headers);
        ResponseEntity<String> token = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        return token.getHeaders().get(authorizationHeadersAuth).stream().findFirst().get();
    }

}
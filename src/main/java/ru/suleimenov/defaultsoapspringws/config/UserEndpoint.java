package ru.suleimenov.defaultsoapspringws.config;

import generated.GetUserRequest;
import generated.GetUserResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.suleimenov.defaultsoapspringws.service.UserService;
@Slf4j
@Endpoint
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserEndpoint {

    UserService userService;

    @PayloadRoot(namespace = "http://sdr.com/spring-soap-example",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        log.info("Income request: {}", request.getName());
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUserByName(request.getName()));
        return response;
    }

}

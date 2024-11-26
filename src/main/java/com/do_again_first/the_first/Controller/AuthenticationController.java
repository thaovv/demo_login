package com.do_again_first.the_first.Controller;

import com.do_again_first.the_first.Dto.Request.ApiResponse;
import com.do_again_first.the_first.Dto.Request.AuthenticationRequest;
import com.do_again_first.the_first.Dto.Request.IntrospectRequest;
import com.do_again_first.the_first.Dto.Response.AuthenticationResponse;
import com.do_again_first.the_first.Dto.Response.IntrospectResponse;
import com.do_again_first.the_first.Service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
               var result =  authenticationService.authenticate(request);
                return ApiResponse.<AuthenticationResponse>builder()
                        .result(result)
                        .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result =  authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}

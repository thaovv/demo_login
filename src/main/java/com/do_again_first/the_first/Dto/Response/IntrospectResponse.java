package com.do_again_first.the_first.Dto.Response;

;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class IntrospectResponse {
    boolean valid;
}

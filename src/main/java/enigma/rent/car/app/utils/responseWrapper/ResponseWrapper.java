package enigma.rent.car.app.utils.responseWrapper;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseWrapper {
    private Integer status;
    private String message;
    private Object data;
}

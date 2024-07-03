package enigma.rent.car.app.utils.responseWrapper;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WebResponse<T> {
    private String status;
    private String message;
    private Object data;
}

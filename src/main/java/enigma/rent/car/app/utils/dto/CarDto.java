package enigma.rent.car.app.utils.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarDto {
    @NotBlank
    private String name;
    @NotNull
    private Integer brand_id;
    private Boolean available=true;
    @NotNull
    private Integer price;
}

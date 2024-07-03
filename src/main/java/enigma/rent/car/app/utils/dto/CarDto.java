package enigma.rent.car.app.utils.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
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
    @NotNull
    private Integer price;
    private Boolean available=true;
}

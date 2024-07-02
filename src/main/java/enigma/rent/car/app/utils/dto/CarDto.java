package enigma.rent.car.app.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String name;
    private Integer brand_id;
    private Boolean available;
    private Integer price;
}

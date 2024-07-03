package enigma.rent.car.app.utils.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarDto {
    private Integer id;
    private String name;
    private Integer brand_id;
    private Boolean available;
    private Integer price;
}

package enigma.rent.car.app.utils.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RentDto {
    private Integer user_id;
    private Integer price;
    private LocalDate ends_at;
    private Integer car_id;
}

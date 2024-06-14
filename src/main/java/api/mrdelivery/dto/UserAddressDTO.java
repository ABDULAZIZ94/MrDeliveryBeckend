package api.mrdelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressDTO {

    private Long address_id;

    private String address_line1;

    private String address_line2;

    private String city;

    private String state;

    private String postal_code;

    private String country;

    private boolean is_primary;
}

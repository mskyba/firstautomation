package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.jackson.Jacksonized;


@Data
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetDto {
    private String name;
    private String status;

}


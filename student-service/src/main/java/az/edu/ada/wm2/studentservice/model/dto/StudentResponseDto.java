package az.edu.ada.wm2.studentservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {

    @Schema(description = "Tələbə unikal identifikatoru", example = "1")
    private Long id;
    @Schema(description = "Tələbə adı", example = "Nicat")
    private String firstName;
    @Schema(description = "Tələbə soyadı", example = "Aliyev")
    private String lastName;
    @Schema(description = "Tələbə e-poçtu", example = "nicat.aliyev@example.com")
    private String email;
    @Schema(description = "Tələbə yaşı", example = "20")
    private Integer age;
}

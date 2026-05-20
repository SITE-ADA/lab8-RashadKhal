package az.edu.ada.wm2.courseservice.model.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponseDto {

    @Schema(description = "Qeydiyyat ID-si", example = "10")
    private Long enrollmentId;

    @Schema(description = "Kursun ID-si", example = "1")
    private Long courseId;

    @Schema(description = "Tələbə ID-si", example = "15")
    private Long studentId;

    @Schema(description = "Əməliyyat nəticəsi", example = "Tələbə müvəffəqiyyətlə qeydiyyatdan keçdi.")
    private String message;

    @Schema(description = "Qeydiyyat tarixi", example = "2024-06-01")
    private LocalDate enrollmentDate;
}

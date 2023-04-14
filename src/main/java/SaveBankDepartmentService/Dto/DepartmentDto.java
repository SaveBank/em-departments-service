package SaveBankDepartmentService.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long id;

    @NotEmpty(message = "department name should not be null or empty")
    private String departmentName;

    @NotEmpty(message = "department description should not be null or empty")
    private String departmentDescription;

    @NotEmpty(message = "department code should not be null or empty")
    private String departmentCode;
}

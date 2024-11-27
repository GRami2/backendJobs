package apis.com.dto;
 
import lombok.AllArgsConstructor;

import java.time.LocalDate;

import lombok.*; 


@Data
@NoArgsConstructor
@AllArgsConstructor 
public class JobDto {
	private Long id;
    private String title;
    private String jobDescription;
    private String typeOfContract;
    private String remoteWorking;
    private String profileRequired;
    private String skillsExpertise;
    private String experiences;
    private String typeCompany;
    private Long sectorId;
    private String state;
    private String languages;
    private String city;
    private LocalDate estimatedStartDate;
}
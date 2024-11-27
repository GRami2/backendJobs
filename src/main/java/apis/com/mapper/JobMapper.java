package apis.com.mapper; 

import org.springframework.stereotype.Component;

import apis.com.dto.JobDto;
import apis.com.entities.Job;
import apis.com.enums.NiveauExperiences;
import apis.com.enums.RemoteWorking;
import apis.com.enums.State;
import apis.com.enums.TypeCompany;
import apis.com.enums.TypeOfContract;
import apis.com.repository.SectorRepository;

@Component
public class JobMapper {
	
	private final SectorRepository sectorRepository;

    public JobMapper(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public JobDto convertToDTO(Job job) {
    	JobDto dto = new JobDto();
    	dto.setId(job.getId());
        dto.setTitle(job.getTitle());
        dto.setJobDescription(job.getJobDescription());
        dto.setTypeOfContract(job.getTypeOfContract().name());
        dto.setRemoteWorking(job.getRemoteWorking().name());
        dto.setProfileRequired(job.getProfileRequired());
        dto.setSkillsExpertise(job.getSkillsExpertise());
        dto.setExperiences(job.getExperiences().name());
        dto.setTypeCompany(job.getTypeCompany().name());
        dto.setSectorId(job.getSectorOfActivity().getId());
        dto.setState(job.getState().name());
        dto.setLanguages(job.getLanguages());
        dto.setCity(job.getCity());
        dto.setEstimatedStartDate(job.getEstimatedStartDate());
        return dto;
    }

    public Job convertToEntity(JobDto dto) {
        Job job = new Job(); 
        job.setTitle(dto.getTitle());
        job.setJobDescription(dto.getJobDescription());
        job.setTypeOfContract(TypeOfContract.valueOf(dto.getTypeOfContract()));
        job.setRemoteWorking(RemoteWorking.valueOf(dto.getRemoteWorking()));
        job.setProfileRequired(dto.getProfileRequired());
        job.setSkillsExpertise(dto.getSkillsExpertise());
        job.setExperiences(NiveauExperiences.valueOf(dto.getExperiences()));
        job.setTypeCompany(TypeCompany.valueOf(dto.getTypeCompany()));
        job.setState(State.valueOf(dto.getState()));
        job.setLanguages(dto.getLanguages());
        job.setCity(dto.getCity());
        job.setEstimatedStartDate(dto.getEstimatedStartDate());
        if (dto.getSectorId() != null) {
            job.setSectorOfActivity(sectorRepository.findById(dto.getSectorId()).get()); 
        } 
        return job;
    }
}
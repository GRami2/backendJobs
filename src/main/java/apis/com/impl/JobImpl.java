package apis.com.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import apis.com.dto.JobDto;
import apis.com.entities.Job;
import apis.com.mapper.JobMapper;
import apis.com.repository.JobRepository;
import apis.com.service.JobService; 

@Service
public class JobImpl implements JobService{
	
	private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    public JobImpl(JobRepository jobRepository, JobMapper jobMapper) {
        this.jobRepository = jobRepository;
        this.jobMapper = jobMapper;
    }
    
	@Override
	public List<JobDto> getAllJobs() {
		return jobRepository.findAll().stream()
                .map(jobMapper::convertToDTO)
                .collect(Collectors.toList());
	}

	@Override
	public JobDto getJobById(Long id) {
		Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));
        return jobMapper.convertToDTO(job);
	}

	@Override
	public JobDto createJob(JobDto jobDto) {System.out.println("Goooooooo");
		Job job = jobMapper.convertToEntity(jobDto);System.out.println("Supeerrrrrr");
		System.out.println(job.toString());
        Job savedJob = jobRepository.save(job);
        return jobMapper.convertToDTO(savedJob);
	}

	@Override
	public JobDto updateJob(Long id, JobDto jobDto) {
		return jobRepository.findById(id)
                .map(existingJob -> {
                    // Convertir le DTO en entité tout en préservant l'ID existant
                    Job updatedJob = jobMapper.convertToEntity(jobDto);
                    updatedJob.setId(existingJob.getId());
                    Job savedJob = jobRepository.save(updatedJob);
                    return jobMapper.convertToDTO(savedJob);
                }).orElseThrow(() -> new RuntimeException("Job not found with id " + id));
	}

	@Override
	public void deleteJob(Long id) {
		if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found with id " + id);
        }
        jobRepository.deleteById(id);
	}

}

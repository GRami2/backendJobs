package apis.com.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.com.repository.JobRepository;
import apis.com.repository.SectorRepository;
import apis.com.repository.UserRepository;
import apis.com.service.StatisticsService;

@Service
public class StatisticsImpl implements StatisticsService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SectorRepository sectorRepository;
	@Autowired
	private JobRepository jobRepository;
	
	@Override
	public Map<String, Long> getStatistics() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("jobs", jobRepository.count());
        stats.put("sectors", sectorRepository.count());
        stats.put("users", userRepository.count()-1);
        return stats;
    }
}

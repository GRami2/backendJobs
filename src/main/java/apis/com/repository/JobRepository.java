package apis.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apis.com.entities.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}

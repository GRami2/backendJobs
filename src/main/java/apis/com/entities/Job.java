package apis.com.entities;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import apis.com.enums.NiveauExperiences;
import apis.com.enums.RemoteWorking;
import apis.com.enums.State;
import apis.com.enums.TypeCompany;
import apis.com.enums.TypeOfContract;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data; 
import lombok.NoArgsConstructor; 

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder
public class Job {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String jobDescription;

    @Enumerated(EnumType.STRING)
    private TypeOfContract typeOfContract;

    @Enumerated(EnumType.STRING)
    private RemoteWorking remoteWorking;

    @Column(columnDefinition = "TEXT")
    private String profileRequired;

    @Column(columnDefinition = "TEXT")
    private String skillsExpertise;

    @Enumerated(EnumType.STRING)
    private NiveauExperiences experiences;

    @Enumerated(EnumType.STRING)
    private TypeCompany typeCompany;
    
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
    
    @ManyToOne
    @JoinColumn(name="sector_id")
    private Sector sectorOfActivity;
    
    @Enumerated(EnumType.STRING)
    private State state; 
    
    private String languages;
    private String city;
    private LocalDate estimatedStartDate;
    
}

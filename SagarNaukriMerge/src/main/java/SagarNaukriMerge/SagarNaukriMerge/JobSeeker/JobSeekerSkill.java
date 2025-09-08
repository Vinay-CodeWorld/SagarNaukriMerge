package SagarNaukriMerge.SagarNaukriMerge.JobSeeker;

import SagarNaukriMerge.SagarNaukriMerge.JobSeeker.Skills_two.Skill;
import jakarta.persistence.*;

@Entity
@Table(name = "job_seeker_skills")
public class JobSeekerSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    public JobSeekerSkill() {
    }

    public JobSeekerSkill(JobSeeker jobSeeker, Skill skill) {
        this.jobSeeker = jobSeeker;
        this.skill = skill;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
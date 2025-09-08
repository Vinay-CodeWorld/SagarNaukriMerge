package SagarNaukriMerge.SagarNaukriMerge.JobSeeker;

import SagarNaukriMerge.SagarNaukriMerge.JobSeeker.Skills_two.Skill;
import SagarNaukriMerge.SagarNaukriMerge.JobSeeker.Skills_two.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobSeekerSkillService {
    private final JobSeekerSkillRepository jobSeekerSkillRepository;
    private final JobSeekerRepository jobSeekerRepository;
    private final SkillRepository skillRepository;

    @Autowired
    public JobSeekerSkillService(JobSeekerSkillRepository jobSeekerSkillRepository,
                                 JobSeekerRepository jobSeekerRepository,
                                 SkillRepository skillRepository) {
        this.jobSeekerSkillRepository = jobSeekerSkillRepository;
        this.jobSeekerRepository = jobSeekerRepository;
        this.skillRepository = skillRepository;
    }

    @Transactional
    public void addSkillToJobSeeker(Long jobSeekerId, Long skillId) {
        JobSeeker jobSeeker = jobSeekerRepository.findById(jobSeekerId)
                .orElseThrow(() -> new IllegalArgumentException("JobSeeker not found"));
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new IllegalArgumentException("Skill not found"));

        if (!jobSeekerSkillRepository.existsByJobSeekerAndSkill(jobSeeker, skill)) {
            JobSeekerSkill jobSeekerSkill = new JobSeekerSkill(jobSeeker, skill);
            jobSeekerSkillRepository.save(jobSeekerSkill);
        }
    }

    @Transactional
    public void removeSkillFromJobSeeker(Long jobSeekerId, Long skillId) {
        JobSeekerSkill jobSeekerSkill = jobSeekerSkillRepository
                .findByJobSeekerIdAndSkillId(jobSeekerId, skillId)
                .orElseThrow(() -> new IllegalArgumentException("Skill not associated with this job seeker"));

        jobSeekerSkillRepository.delete(jobSeekerSkill);
    }

    @Transactional(readOnly = true)
    public List<JobSeekerSkill> getSkillsForJobSeeker(Long jobSeekerId) {
        return jobSeekerSkillRepository.findByJobSeeker_JSId(jobSeekerId);
    }
}
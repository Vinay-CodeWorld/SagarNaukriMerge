package SagarNaukriMerge.SagarNaukriMerge.JobSeeker;

import SagarNaukriMerge.SagarNaukriMerge.JobSeeker.Skills_two.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobSeekerSkillRepository extends JpaRepository<JobSeekerSkill, Long> {
    List<JobSeekerSkill> findByJobSeeker_JSId(Long jobSeekerId);
    boolean existsByJobSeekerAndSkill(JobSeeker jobSeeker, Skill skill);
    void deleteByJobSeekerAndSkill(JobSeeker jobSeeker, Skill skill);

    @Query("SELECT js FROM JobSeekerSkill js WHERE js.jobSeeker.JSId = :jobSeekerId AND js.skill.id = :skillId")
    Optional<JobSeekerSkill> findByJobSeekerIdAndSkillId(@Param("jobSeekerId") Long jobSeekerId,
                                                         @Param("skillId") Long skillId);
   // boolean existsByJobSeekerAndSkill(JobSeeker jobSeeker, Skill skill);
}
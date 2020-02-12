package com.jamesaq12wsx.portfolio.repository;

import com.jamesaq12wsx.portfolio.model.Resume;
import com.jamesaq12wsx.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ResumeRepository extends JpaRepository<Resume, UUID> {

    @Query(
            value = "select r.* from account a join resume r on a.user_id = r.user_id where a.username = :username",
            nativeQuery = true
    )
    Optional<Resume> findResumeByUsername(@Param("username") String username);
}

package edu.miu.cs590.notificationservice.repository;

import edu.miu.cs590.notificationservice.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {

    @Query("select m from Email m where m.sendStatus=false")
    List<Email> findEmailToSend();
}

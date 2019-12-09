package com.example.template.repository;


import com.example.template.model.SeqUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeqUserRepository extends JpaRepository<SeqUser, String> {
    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true else FALSE END FROM SeqUser s WHERE s.key=?1")
    Boolean existsByKey(String key);

    @Query("SELECT s FROM SeqUser s WHERE s.key=?1")
    SeqUser findFirstByKey(String key);
}

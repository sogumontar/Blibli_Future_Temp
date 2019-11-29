package com.example.template.repository;

import com.example.template.model.SeqProduct;
import com.example.template.model.SeqUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeqProductRepository extends JpaRepository<SeqProduct,String> {
    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true else FALSE END FROM SeqProduct s WHERE s.key=?1")
    Boolean existsByKey(String key);

    @Query("SELECT s FROM SeqProduct s WHERE s.key=?1")
    SeqProduct findFirstByKey(String key);
}

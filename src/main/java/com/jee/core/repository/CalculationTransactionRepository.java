package com.jee.core.repository;

import com.jee.core.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Geoffrey on 26.06.2018
 */
@Repository
public interface CalculationTransactionRepository extends JpaRepository<Calculation, Long> {
    //empty
}

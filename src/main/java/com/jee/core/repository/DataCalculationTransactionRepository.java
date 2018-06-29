package com.jee.core.repository;

import com.jee.core.model.CalculatedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Geoffrey on 28.08.2018
 */
@Repository
public interface DataCalculationTransactionRepository extends JpaRepository<CalculatedData, Long>, DataCalculationTransactionRepositoryEx {
    //empty
}

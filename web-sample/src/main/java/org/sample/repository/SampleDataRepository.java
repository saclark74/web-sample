package org.sample.repository;

import org.sample.repository.internal.SampleDataRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.sample.model.SampleData;

/**
 * Created by Scott on 6/11/2015.
 */
public interface SampleDataRepository extends JpaRepository<SampleData, Long>
    ,SampleDataRepositoryCustom
    ,QueryDslPredicateExecutor<SampleData>
    {

    SampleData findByUsage( String usage );

    @Query("select d from SampleData d where d.usage = ?1")
    SampleData findByUsageViaQueryAttribute(String usage);
}

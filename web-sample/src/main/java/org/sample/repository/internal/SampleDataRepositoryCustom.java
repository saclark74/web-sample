package org.sample.repository.internal;

import com.mysema.query.jpa.impl.JPAQuery;
import org.sample.model.QSampleData;
import org.sample.model.SampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by Scott on 6/11/2015.
 */
public interface SampleDataRepositoryCustom {

    SampleData findByUsageViaImplClass( String usage );

    SampleData findByUsageViaQueryDSL(String usage);

}

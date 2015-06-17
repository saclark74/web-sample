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
@Repository
class SampleDataRepositoryImpl
    implements SampleDataRepositoryCustom {

    @Autowired
    private EntityManager em;


    @Override
    public SampleData findByUsageViaImplClass(String usage) {
        return em.createQuery("select d from SampleData d where d.usage = :usage",
            SampleData.class)
            .setParameter("usage", usage)
            .getSingleResult();
    }

    @Override
    public SampleData findByUsageViaQueryDSL(String usage) {
        JPAQuery q = new JPAQuery(em);
        QSampleData sampleData = QSampleData.sampleData;

        return q.from(sampleData)
            .where(sampleData.usage.eq(usage))
            .singleResult(sampleData);
    }
}


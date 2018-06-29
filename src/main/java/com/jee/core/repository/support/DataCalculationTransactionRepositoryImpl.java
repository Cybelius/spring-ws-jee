package com.jee.core.repository.support;

import com.jee.core.model.CalculatedData;
import com.jee.core.repository.DataCalculationTransactionRepositoryEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Geoffrey on 29.06.2018
 */
class DataCalculationTransactionRepositoryImpl implements DataCalculationTransactionRepositoryEx {

    /**
     */
    private static final Logger log = LoggerFactory.getLogger(DataCalculationTransactionRepositoryImpl.class);

    /**
     */
    @PersistenceContext
    private EntityManager em;

    /**
     */
    public DataCalculationTransactionRepositoryImpl() {
        super();
    }

    /**
     * @see DataCalculationTransactionRepositoryEx#findAllByTemperature()
     */
    @Override
    public List<CalculatedData> findAllByTemperature() {
        log.info("start transaction temperature sensor");

        final String param = "temperatureSensor";

        final TypedQuery<CalculatedData> query = this.em.createQuery(
                "SELECT cd FROM CalculatedData cd " + "WHERE cd.deviceType = ?1 ORDER BY cd.dateType ASC ", CalculatedData.class
        );
        query.setParameter(1, param);

        return query.getResultList();
    }

    /**
     * @see DataCalculationTransactionRepositoryEx#findAllByHumidity()
     */
    @Override
    public List<CalculatedData> findAllByHumidity() {
        log.info("start transaction humidity sensor");

        final String param = "humiditySensor";

        final TypedQuery<CalculatedData> query = this.em.createQuery(
                "SELECT cd FROM CalculatedData cd " + "WHERE cd.deviceType = ?1 ORDER BY cd.dateType ASC ", CalculatedData.class
        );
        query.setParameter(1, param);

        return query.getResultList();
    }

    /**
     * @see DataCalculationTransactionRepositoryEx#findAllByCo2()
     */
    @Override
    public List<CalculatedData> findAllByCo2() {
        log.info("start transaction co2 sensor");

        final String param = "co2Sensor";

        final TypedQuery<CalculatedData> query = this.em.createQuery(
                "SELECT cd FROM CalculatedData cd " + "WHERE cd.deviceType = ?1 ORDER BY cd.dateType ASC ", CalculatedData.class
        );
        query.setParameter(1, param);

        return query.getResultList();
    }

    /**
     * @see DataCalculationTransactionRepositoryEx#findAllBySoundLevel()
     */
    @Override
    public List<CalculatedData> findAllBySoundLevel() {
        log.info("start transaction soundLevel sensor");

        final String param = "soundLevelSensor";

        final TypedQuery<CalculatedData> query = this.em.createQuery(
                "SELECT cd FROM CalculatedData cd " + "WHERE cd.deviceType = ?1 ORDER BY cd.dateType ASC ", CalculatedData.class
        );
        query.setParameter(1, param);

        return query.getResultList();
    }

    /**
     * @see DataCalculationTransactionRepositoryEx#findAllByDates(long, long)
     */
    @Override
    public List<CalculatedData> findAllByDates(final long startDate, final long endDate) {
        log.debug("startDate: {}, endDate: {}", startDate, endDate);
        log.info("start transaction sensor for date range");

        final String param = "soundLevelSensor";

        final TypedQuery<CalculatedData> query = this.em.createQuery(
                "SELECT cd FROM CalculatedData cd "
                        + "WHERE cd.date >= ?1 AND cd.date < ?2 AND cd.deviceType = ?3"
                        + "ORDER BY cd.dateType ASC ", CalculatedData.class
        );
        query.setParameter(1, startDate);
        query.setParameter(2, endDate);
        query.setParameter(3, param);

        return query.getResultList();
    }

}

package org.acme.quarkus.introduction.service;

import org.acme.quarkus.introduction.model.Portfolio;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PortfolioService {

    @Inject
    EntityManager entityManager;

    public Portfolio[] findPortfolio(int offset, int total) {
        return (Portfolio[])entityManager.createNativeQuery("SELECT ID,CODE,AMOUNT,DEVISE,MANAGER FROM Portfolio ORDER BY id ASC LIMIT :offset , :total ", Portfolio.class)
                .setParameter("offset", offset)
                .setParameter("total", total)
                .getResultList()
                .toArray(new Portfolio[0]);
    }
}

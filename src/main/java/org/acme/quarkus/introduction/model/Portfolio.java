package org.acme.quarkus.introduction.model;


import org.acme.quarkus.introduction.model.enums.Devise;

import javax.persistence.*;

@Entity
@Table(name = "Portfolio")
public class Portfolio {
    @Id
    @SequenceGenerator(name = "portfoliosSequence",sequenceName = "known_portfolios_id_seq")
    @GeneratedValue(generator = "portfoliosSequence")
    private long id;
    private String code;
    private int amount;
    private Devise devise;
    private String manager;

    public Portfolio() {
    }


    public Portfolio(long id, String code, int amount, Devise devise, String manager) {
        this.id = id;
        this.code = code;
        this.amount = amount;
        this.devise = devise;
        this.manager = manager;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}

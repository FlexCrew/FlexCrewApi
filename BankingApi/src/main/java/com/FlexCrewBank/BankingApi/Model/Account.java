package com.FlexCrewBank.BankingApi.Model;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private Long id;

    private enum Type{
        CHECKING, SAVINGS, REWARDS
    }

    @Column(name = "ACCOUNT_NICKNAME")
    private String nickname;

    @Column(name = "ACCOUNT_REWARDS")
    private Integer rewards;

    @Column(name = "ACCOUNT_BALANCE")
    private Double balance;

    @JoinColumn(name = "ACCOUNT_CUSTOMER")
    @Embedded
    private Customer customer;

    @Column(name = "ACCOUNT_TYPE")
    @Enumerated(EnumType.STRING)
    private Type type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}


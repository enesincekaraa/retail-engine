package com.enesincekara.retail.domain.shared;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Money implements Serializable {

    private final BigDecimal amount;
    private final String currency;
    public Money(BigDecimal amount, String currency) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        this.amount = amount;
        this.currency = currency;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }

    public Money add(Money other) {
        if (!currency.equals(other.getCurrency())) {
            throw new IllegalArgumentException("Cannot add money with different currencies");
        }
        return new Money(amount.add(other.getAmount()), currency);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return Objects.equals(amount, money.amount)
                && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}

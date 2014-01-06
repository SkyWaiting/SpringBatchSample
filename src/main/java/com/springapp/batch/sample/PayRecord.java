package com.springapp.batch.sample;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 14-1-6
 * Time: 下午3:22
 */
public class PayRecord {

    private Long id;

    private Bill bill;

    private Double paidFees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Double getPaidFees() {
        return paidFees;
    }

    public void setPaidFees(Double paidFees) {
        this.paidFees = paidFees;
    }
}

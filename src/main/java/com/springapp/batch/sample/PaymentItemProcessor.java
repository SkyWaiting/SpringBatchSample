package com.springapp.batch.sample;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 14-1-6
 * Time: 下午3:19
 */
public class PaymentItemProcessor implements ItemProcessor<Bill, PayRecord> {

    /**
     * Process the provided item, returning a potentially modified or new item for continued
     * processing.  If the returned result is null, it is assumed that processing of the item
     * should not continue.
     *
     * @param bill to be processed
     * @return potentially modified or new item for continued processing, null if processing of the
     *         provided item should not continue.
     * @throws Exception
     */
    @Override
    public PayRecord process(Bill bill) throws Exception {
        if (bill.getUser().getBalance() <= 0){
            return null;
        }

        if (bill.getUser().getBalance() >= bill.getUnpaidFees()){
            //create payrecord
            PayRecord pr = new PayRecord();
            pr.setBill(bill);
            pr.setPaidFees(bill.getUnpaidFees());
            //update balance
            bill.getUser().setBalance(bill.getUser().getBalance() - bill.getUnpaidFees());
            //update bill
            bill.setPaidFees(bill.getUnpaidFees());
            bill.setUnpaidFees(0.0);
            bill.setPayStatus(1); /* paid */
            return pr;
        }else {
            throw new MoneyNotEnoughException();
        }
    }
}

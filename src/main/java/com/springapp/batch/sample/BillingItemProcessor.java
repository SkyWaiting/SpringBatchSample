package com.springapp.batch.sample;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-12-31
 * Time: 下午8:24
 */
public class BillingItemProcessor implements ItemProcessor<User, Bill> {
    /**
     * Process the provided item, returning a potentially modified or new item for continued
     * processing.  If the returned result is null, it is assumed that processing of the item
     * should not continue.
     *
     * @param item to be processed
     * @return potentially modified or new item for continued processing, null if processing of the
     *         provided item should not continue.
     * @throws Exception
     */
    @Override
    public Bill process(User item) throws Exception {
        Bill b = new Bill();
        b.setUser(item);
        b.setFees(70.00);
        b.setPaidFees(0.0);
        b.setUnpaidFees(70.00);
        b.setPayStatus(0);
        return b;
    }
}

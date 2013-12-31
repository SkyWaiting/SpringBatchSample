package com.springapp.batch.sample;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-12-27
 * Time: 下午12:56
 */
public class MessagesItemProcessor implements ItemProcessor<User,Message>{
    /**
     * Process the provided item, returning a potentially modified or new item for continued
     * processing.  If the returned result is null, it is assumed that processing of the item
     * should not continue.
     *
     * @param user to be processed
     * @return potentially modified or new item for continued processing, null if processing of the
     *         provided item should not continue.
     * @throws Exception
     */
    @Override
    public Message process(User user) throws Exception {
        Message m = new Message();
        m.setContent("Hello "+user.getName()+",please pay promptly at the end of month.");
        return m;
    }
}

package com.springapp.batch.sample;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-12-27
 * Time: 下午12:50
 *
 */
public class MessagesItemWriter implements ItemWriter<Message>{
    /**
     * Process the supplied data element. Will not be called with any null items
     * in normal operation.
     *
     * @throws Exception if there are errors. The framework will catch the
     *                   exception and convert or rethrow it as appropriate.
     */
    @Override
    public void write(List<? extends Message> messages) throws Exception {
        System.out.println("write results");
        for (Message m : messages){
            System.out.println(m.getContent());
        }
    }
}

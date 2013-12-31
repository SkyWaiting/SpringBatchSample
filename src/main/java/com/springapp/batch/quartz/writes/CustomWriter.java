package com.springapp.batch.quartz.writes;

import com.springapp.batch.quartz.model.Report;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-12-28
 * Time: 上午9:21
 */
public class CustomWriter implements ItemWriter<Report>{
    /**
     * Process the supplied data element. Will not be called with any null items
     * in normal operation.
     *
     * @throws Exception if there are errors. The framework will catch the
     *                   exception and convert or rethrow it as appropriate.
     */
    @Override
    public void write(List<? extends Report> items) throws Exception {
        System.out.println("writer..." + items.size());
        for (Report item : items){
            System.out.println(item);
        }
    }
}

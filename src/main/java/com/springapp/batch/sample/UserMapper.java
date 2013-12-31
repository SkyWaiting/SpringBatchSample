package com.springapp.batch.sample;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-12-27
 * Time: 上午10:08
 *
 */
public class UserMapper implements FieldSetMapper<User>{
    /**
     * Method used to map data obtained from a {@link org.springframework.batch.item.file.transform.FieldSet} into an object.
     *
     * @param fieldSet the {@link org.springframework.batch.item.file.transform.FieldSet} to map
     * @throws org.springframework.validation.BindException
     *          if there is a problem with the binding
     */
    @Override
    public User mapFieldSet(FieldSet fieldSet) throws BindException {
        User u = new User();
        u.setName(fieldSet.readString(0));
        u.setAge(fieldSet.readInt(1));
        return u;
    }
}

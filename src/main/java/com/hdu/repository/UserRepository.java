package com.hdu.repository;

import com.hdu.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author 范正荣
 * @Date 2017/12/16 0016 19:48.
 */
public interface UserRepository extends CrudRepository<User,Long> {

}

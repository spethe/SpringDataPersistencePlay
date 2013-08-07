package repo;

import models.User;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: swanand
 * Date: 31/7/13
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@Singleton
public interface JPARepo extends CrudRepository<User, String> {
}

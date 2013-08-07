//package repo;
//
//import com.avaje.ebean.Ebean;
//import models.User;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//import javax.inject.Named;
//
//
///**
// * Created with IntelliJ IDEA.
// * User: swanand
// * Date: 24/7/13
// * Time: 3:22 PM
// * To change this template use File | Settings | File Templates.
// */
//@Repository
//public class EbeanUserRepo implements UserRepository {
//
//    public boolean authorize(String username, String password) {
//        System.out.println(username + password);
//        User authUser = Ebean.find(User.class).where().eq("username",username).eq("password", password).findUnique();
//        System.out.println(authUser);
//        return (authUser == null) ? false : true;
//    }
//}

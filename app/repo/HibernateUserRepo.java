//package repo;
//
//import models.User;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//import play.db.jpa.JPA;
//import play.db.jpa.Transactional;
//
//import javax.inject.Named;
//import javax.persistence.*;
//
///**
// * Created with IntelliJ IDEA.
// * User: swanand
// * Date: 30/7/13
// * Time: 5:05 PM
// * To change this template use File | Settings | File Templates.
// */
//@Repository
//public class HibernateUserRepo implements UserRepository {
//
//    @PersistenceContext(unitName = "defaultPersistenceUnit")
//    EntityManager entityManager;
//
//    @Override
//    public boolean authorize(String username, String password) {
//        if(entityManager == null){
//            System.out.println("Entity Manager NULL");
//        }
//        User user = entityManager.find(User.class, username);
//        System.out.println("Got user " + user);
//        return true;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
////    public HibernateUserRepo() {
////        System.out.println("Hibernate getting instantiated");
////    }
////
//////    @Override
////    public boolean authorize(String username, String password) {
//////        EntityManager entityManager = JPA.em("default");
//////        JPA.bindForCurrentThread(entityManager);
//////        User user = entityManager.find(User.class, username);
//////        System.out.println(user);
//////        return (user == null) ? false : true;
////        return true;
////    }
//}

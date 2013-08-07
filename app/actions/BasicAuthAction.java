package actions;

import models.User;
import org.apache.commons.codec.binary.Base64;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import repo.JPARepo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
* Created with IntelliJ IDEA.
* User: swanand
* Date: 23/7/13
* Time: 12:55 PM
* To change this template use File | Settings | File Templates.
*/

@Named
@Singleton
public class BasicAuthAction extends Action.Simple {

    private static final String AUTHORIZATION = "Authorization";

    private final JPARepo hiber;

    @Inject
    public BasicAuthAction(final JPARepo hiber) {
        this.hiber = hiber;
    }

    @Override
    public Result call(Http.Context context) throws Throwable {

        String authHeader = context.request().getHeader(AUTHORIZATION);

        if(authHeader == null){
            return unauthorized();
        } else {
            String auth = authHeader.substring(6);
            byte[] decodedAuth = new Base64().decodeBase64(auth);
            String[] credString = new String(decodedAuth, "UTF-8").split(":");

            if (credString == null || credString.length != 2) {
                return unauthorized();
            }

            String username = credString[0];
            String password = credString[1];

            return (findUser(username, password)) ? ok("Authorized") : unauthorized("Unauthorized User");
        }
    }


    private boolean findUser(String username, String password) {

       User user = hiber.findOne(username);
       if(user == null){
           return false;
       }

       if(user.password.equals(password)){
            return true;
        }

       return false;
    }
}
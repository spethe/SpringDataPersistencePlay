import java.util.*;

import actions.BasicAuthAction;
import controllers.Application;
import controllers.routes;
import org.codehaus.jackson.JsonNode;
import org.junit.*;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import play.GlobalSettings;
import play.api.mvc.*;
import play.api.mvc.Call;
import play.api.mvc.Content;
import play.mvc.*;
import play.mvc.Result;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {


    @Mock
    private BasicAuthAction basicAuthAction;

    @Mock
    private Http.Context context;

    @Mock
    private RequestHeader _requestHeader;
    private Application controllerUnderTest;

//    @BeforeClass
//    public static void startApp() {
//        app = Helpers.fakeApplication();
//        Helpers.start(app);
//    }
//
    @Before
    public void setUpControllers() {
        controllerUnderTest = new Application();
        final GlobalSettings settings = new GlobalSettings() {
            @Override
            public <A> A getControllerInstance(Class<A> aClass) throws Exception {
                return (A) controllerUnderTest;
            }
        };
        start(fakeApplication(settings));

    }

    @Test 
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }
    
 //   @Test
//    public void renderTemplate() {
//        Content html = views.html.index.render("Your new application is ready.");
//        assertThat(contentType(html)).isEqualTo("text/html");
//        assertThat(contentAsString(html)).contains("Your new application is ready.");
//    }

    @Test
    public void loginRouteIsWorking() throws Throwable {
        //When
        Result result = routeAndCall(fakeRequest(POST, "/login"));
        //Then
        assertThat(result).isNotNull();
    }

    @Test
    public void shouldAuthenticateUser() throws Throwable {
        //Given
        //When
        controllerUnderTest.setBasicAuthAction(basicAuthAction);
        controllerUnderTest.setContext(context);
        Result result = controllerUnderTest.authenticate();

        //Then
        verify(basicAuthAction).call(context);
    }

}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UITest extends AbstractTest{
    @Test
    void testGBNotEmailLogin() {

        loginPage.login("login", "password");
        String textLogin = loginPage.getTextLogin();
        Assertions.assertFalse(textLogin.isEmpty());
    }

    @Test
    void testGBWithoutPassword() {
        loginPage.login("login@login.ru", "");
        String textPassword = loginPage.getTextPassword();
        Assertions.assertFalse(textPassword.isEmpty());
    }
}

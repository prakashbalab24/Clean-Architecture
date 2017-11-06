package singledev.cleanarchitecture.Login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by batman on 06/11/17.
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MM.:  .:'   `:::  .:`MMMMMMMMMMM|`MMM'|MMMMMMMMMMM':  .:'   `:::  .:'.MM
 * MMMM.     :          `MMMMMMMMMM  :*'  MMMMMMMMMM'        :        .MMMM
 * MMMMM.    ::    .     `MMMMMMMM'  ::   `MMMMMMMM'   .     ::   .  .MMMMM
 * MMMMMMM    ;::         ;::         ;::         ;::         ;::   MMMMMMM
 * MMMMMMM .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `::MMMMMMM
 * MMMMM'______::____      ::    .     ::    .     ::     ___._::____`MMMMM
 * MMMMMMMMMMMMMMMMMMM`---._ :: ::'  :   :: ::'  _.--::MMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMM::.         ::  .--MMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM-.     ;::-MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM. .:' .M:F_P:MMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.   .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\ /MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMVMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 */

public class LoginPresenterImplementation implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImplementation(LoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public void validateLogin(final String username, final String password) {
        if (loginView!=null){

            loginView.showProgress();
            new Handler().postDelayed(new Runnable() {
                @Override public void run() {
                    boolean error = false;
                    if (TextUtils.isEmpty(username)){
                        error = true;
                        loginView.dissmissProgress();
                        loginView.showMsg("UserName / Password Cannot be Empty!!");
                        return;
                    }
                    if (TextUtils.isEmpty(password)){
                        error = true;
                        loginView.dissmissProgress();
                        loginView.showMsg("UserName / Password Cannot be Empty!!");
                        return;
                    }
                    if (!error){
                        if (username.equalsIgnoreCase("test") && username.equalsIgnoreCase("test")) {
                            loginView.dissmissProgress();
                            loginView.showMsg("Login Sucess");
                            loginView.loginSucess();
                            return;
                        }
                        loginView.dissmissProgress();
                        loginView.showMsg("UserName / Password Incorrect");

                    }
                }
            }, 2000);
        }
    }
}

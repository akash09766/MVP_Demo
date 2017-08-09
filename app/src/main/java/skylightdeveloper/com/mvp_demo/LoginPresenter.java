package skylightdeveloper.com.mvp_demo;

/**
 * Created by Akash Wangalwar on 19-06-2017.
 */
public interface LoginPresenter {

    void performLogin(String username, String password);

    void onUserNameError();

    void onPasswordError();

    void onSuccess();

    void onDestroy();

}

package skylightdeveloper.com.mvp_demo;

import javax.inject.Inject;

/**
 * Created by Akash Wangalwar on 19-06-2017.
 */
public interface LoginView {
    void onSuccess();
    void onUserNameError();
    void onPasswordError();
    void showProgress();
    void hideProgress();

}

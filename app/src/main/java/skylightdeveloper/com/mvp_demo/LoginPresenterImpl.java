package skylightdeveloper.com.mvp_demo;

import android.util.Log;

/**
 * Created by Akash Wangalwar on 19-06-2017.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private final LoginInteractor loginInteractorImpl;
    private LoginView view;
    private static final String TAG = LoginPresenterImpl.class.getSimpleName();

    public LoginPresenterImpl(LoginView view) {
        Log.d(TAG, "LoginPresenterImpl Constructor : ");
        this.view = view;
        loginInteractorImpl = new LoginInteractorImpl(this);
    }

    @Override
    public void performLogin(String username, String password) {
        Log.d(TAG, "performLogin: ");
        if (view != null) {
            view.showProgress();
        }
        loginInteractorImpl.verifyLogin(username, password);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onUserNameError() {
        if (view != null) {
            view.onUserNameError();
            view.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (view != null) {
            view.onPasswordError();
            view.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.onSuccess();
            view.hideProgress();
        }
    }
}

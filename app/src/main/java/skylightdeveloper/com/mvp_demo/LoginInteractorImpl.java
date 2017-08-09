package skylightdeveloper.com.mvp_demo;

import android.os.Handler;
import android.util.Log;

/**
 * Created by Akash Wangalwar on 19-06-2017.
 */
public class LoginInteractorImpl implements LoginInteractor {
    private static final String TAG = LoginInteractorImpl.class.getSimpleName();
    private final LoginPresenter presenter;
    private Handler handler;

    public LoginInteractorImpl(LoginPresenter presenter) {
        Log.d(TAG, "LoginInteractorImpl: Constructor ");
        this.presenter = presenter;
        handler = new Handler();
    }

    @Override
    public void verifyLogin(final String userName, final String password) {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "verifyLogin: ");
                if (userName.isEmpty()) {
                    presenter.onUserNameError();
                    return;
                } else if (password.isEmpty()) {
                    presenter.onPasswordError();
                    return;
                }
                presenter.onSuccess();
            }
        }, 2000);

    }

}

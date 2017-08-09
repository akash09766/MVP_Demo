package skylightdeveloper.com.mvp_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import skylightdeveloper.com.mvp_demo.dagger2.DaggerNetComponent;
import skylightdeveloper.com.mvp_demo.dagger2.NetModule;

public class MainActivity extends AppCompatActivity implements LoginView {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.username_et_id)
    EditText mUserNameEt;
    @BindView(R.id.password_et_id)
    EditText mPsdEt;
    @BindView(R.id.progressbar_btn_id)
    ProgressBar mProgressBar;

    @Inject
    LoginPresenterImpl loginPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        DaggerNetComponent.builder().netModule(new NetModule(this)).build().inject(this);
    }

    @OnClick(R.id.login_btn_id)
    public void onLoginBtnClick() {
        Log.d(TAG, "onLoginBtnClick: ");
        loginPresenterImpl.performLogin(mUserNameEt.getText().toString().trim(),
                mPsdEt.getText().toString().trim());
    }

    @Override
    protected void onDestroy() {
        loginPresenterImpl.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onSuccess() {
        Log.d(TAG, "onSuccess: ");
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserNameError() {
        Log.d(TAG, "onUserNameError: ");
        Toast.makeText(this, "Incorrect Username", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPasswordError() {
        Log.d(TAG, "onPasswordError: ");
        Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

}

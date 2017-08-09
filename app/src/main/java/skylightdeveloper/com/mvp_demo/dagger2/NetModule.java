package skylightdeveloper.com.mvp_demo.dagger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import skylightdeveloper.com.mvp_demo.LoginPresenterImpl;
import skylightdeveloper.com.mvp_demo.MainActivity;

/**
 * Created by Akash Wangalwar on 20-06-2017.
 */
@Module
public class NetModule {

    private  MainActivity activity;

    public NetModule(MainActivity activity) {
        this.activity = activity;
    }

    @Singleton
    @Provides
    LoginPresenterImpl provideLoginPresenter(){
        return new LoginPresenterImpl(activity);
    }
}

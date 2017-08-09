package skylightdeveloper.com.mvp_demo.dagger2;

import javax.inject.Singleton;

import dagger.Component;
import skylightdeveloper.com.mvp_demo.MainActivity;

/**
 * Created by Akash Wangalwar on 20-06-2017.
 */
@Singleton
@Component(modules = {NetModule.class})
public interface NetComponent {

    void inject(MainActivity activity);
}

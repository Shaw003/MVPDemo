package com.example.mvpdemo.App;

import com.example.mvpdemo.Base.ABSBaseMVPActivity;
import com.example.mvpdemo.Global.GlobalEvent;
import com.example.mvpdemo.Global.GlobalEventType;
import org.jetbrains.annotations.NotNull;

/**
 * Created by XiaoTong on 2019-09-15.
 */
public abstract class AppBaseActivity extends ABSBaseMVPActivity {

    @Override
    public void notifyGlobalToDealWith(@NotNull Object content) {
        super.notifyGlobalToDealWith(content);

        if (content instanceof GlobalEventType) {
            switch ((GlobalEventType)content) {
                case event_exitApp:
                    System.exit(0);
                    break;
                case event_backToLogin:
                    System.out.println("返回到登录页面");
                    break;
                case event_showLoginDialog:
                    System.out.println("展示登录窗口");
                    break;
            }
        }
    }
}

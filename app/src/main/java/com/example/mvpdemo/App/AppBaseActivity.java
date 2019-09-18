package com.example.mvpdemo.App;

import com.example.mvpdemo.Common.Base.ABSBaseMVPActivity;
import com.example.mvpdemo.Common.Global.GlobalEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Created by XiaoTong on 2019-09-15.
 */
public abstract class AppBaseActivity extends ABSBaseMVPActivity {

    @Override
    public void notifyGlobalToDealWith(@NotNull Object content) {
        super.notifyGlobalToDealWith(content);

        if (content instanceof GlobalEvent) {
            switch ((GlobalEvent)content) {
                case event_exitApp:
                    System.out.println("应用层处理事件-退出程序");
                    break;
                case event_backToLogin:
                    System.out.println("应用层处理事件-返回到登录页面");
                    break;
                case event_showLoginDialog:
                    System.out.println("应用层处理事件-展示登录窗口");
                    break;
            }
        }
    }

    @Override
    public void showLoading() {
        super.showLoading();
        System.out.println("应用层弹窗");
    }
}

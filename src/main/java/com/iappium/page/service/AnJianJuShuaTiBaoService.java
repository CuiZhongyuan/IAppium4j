package com.iappium.page.service;

import io.appium.java_client.android.AndroidDriver;
import org.springframework.stereotype.Service;

@Service
public interface AnJianJuShuaTiBaoService {
    void startMini(AndroidDriver driver);

    void startTx(AndroidDriver driver);
}

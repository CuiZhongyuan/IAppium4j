package com.iappium.business;


import com.iappium.handle.OpenMiniHandle;
import org.testng.annotations.Test;

/**
 * 业务层
 *
 * @author czy
 * @version 1.0.0
 * @date 2020/8/1 23:26
 */
@Test
public class TestCase {

    //测试用例维护
    @Test
    public void cases()  {
        OpenMiniHandle openMiniHandle = new OpenMiniHandle();
        //启动微信APP
        openMiniHandle.weixin();
    }
}

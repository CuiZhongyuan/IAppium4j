import com.iappium.utils.BaseTestngInit;
import com.iappium.utils.WordartDisplayer;
import org.testng.annotations.Test;

public class RunCasesAll {

/**
 * 测试用例总入口
 * */
   @Test
    public void runCases(){
       //显示iappium
        WordartDisplayer.display();
        //执行测试用例入口
        BaseTestngInit baseTestngInit = new BaseTestngInit();
        baseTestngInit.baseTestngInitCode();
    }
}

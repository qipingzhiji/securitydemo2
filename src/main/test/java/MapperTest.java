import com.userLogin.dao.sysrole.SysRoleMapper;
import com.userLogin.entity.sysrole.SysRole;
import com.userLogin.entity.sysrole.SysRoleExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhang_htao on 2019/9/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void getSysRolePer(){
        SysRoleExample sysRoleExample = new SysRoleExample();
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
        System.out.println(sysRoles);
    }

}

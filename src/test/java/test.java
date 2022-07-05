import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.mp.beans.Employee;
import com.feng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    private ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper mapper= ac.getBean("employeeMapper",EmployeeMapper.class);


    @Test
    public void testDatasource() throws SQLException {
        Employee employee= new Employee();
        employee.setAge(13);
        employee.setGender(2);
        employee.setEmail("1728314054@qq.com");
        employee.setLastname("feng");
        employee.setSalary(200.0);

        //insert方法会根据实体类每个值进行非空判断，只有非空的属性对应的字段才会出现在sql语句中
        mapper.insert(employee);

        /*
        * 在原始mybatis中 插入操作需要在<insert> 标签中配置两个属性 才能获取插入数据的主键
        *   1 useGeneratedKeys="true" 设定主键自增
        *   2 keyProperty="id" 设置返回id需要写入对应bean中的变量名
        *
        * 在mybatis Plus中 什么都不需要操作 只需要在对应的bean中设置相同名的变量
        * */
        Integer id= employee.getId();
        System.out.println("ID:"+id);

    }


    @Test
    public void testCommonUpdate(){
        Employee employee= new Employee();
        employee.setId(4);
        employee.setLastname("dong");
        employee.setEmail("2090@qq.com");
        //employee.setGender(0);
        //employee.setAge(32);

        Integer result= mapper.updateById(employee);
        System.out.println("result:"+result);
        //UPDATE tbl_employee SET last_name=?, email=?, gender=?, age=? WHERE id=?


    }


    @Test
    public  void  testCommmonSelect(){
        //SELECT id,last_name,email,gender,age FROM tbl_employee WHERE id=?
        //Employee employee=mapper.selectById(3);
        //System.out.println(employee);


        //SELECT id,last_name,email,gender,age FROM tbl_employee WHERE (id LIKE ? AND last_name LIKE ?)
        //QueryWrapper<Employee> wrapper= new QueryWrapper<>();
        //wrapper.like("id",3).like("last_name","dong");
        //Employee employee2= mapper.selectOne(wrapper);
        //System.out.println(employee2);

        //SELECT id,last_name,email,gender,age FROM tbl_employee WHERE (last_name LIKE ? AND age LIKE ?)
//        QueryWrapper<Employee> wrapper= new QueryWrapper<>();
//        wrapper.like("last_name","feng").like("age",13);
//        List<Employee> employees= mapper.selectList(wrapper);
//        for(Employee employeez:employees){
//            System.out.println(employeez);
//        }

//        SELECT id,last_name,email,gender,age FROM tbl_employee WHERE id IN ( ? , ? , ? )
//          List<Integer> idList= new ArrayList<>();
//          idList.add(1);
//          idList.add(2);
//          idList.add(3);
//          List<Employee> employees=mapper.selectBatchIds(idList);
//          for (Employee employee: employees){
//              System.out.println(employee);
//          }

//        SELECT id,last_name,email,gender,age FROM tbl_employee WHERE gender = ? AND last_name = ?
//        Map<String,Object> coulmnMap = new HashMap<>();
//        coulmnMap.put("last_name","Tom");
//        coulmnMap.put("gender",1);
//        List<Employee> employees=mapper.selectByMap(coulmnMap);
//        for (Employee employee:employees) {
//            System.out.println(employee);
//        }

        //分页查询
        Page<Employee> employeePage=mapper.selectPage(new Page<>(3,2),null);
        List<Employee> employees=employeePage.getRecords();
        for (Employee employee:employees){
            System.out.println(employee);
        }
    }

    @Test
    public void test06(){
        System.out.println("hello feng001");
    }


    public void test07(){
        System.out.println("hello zhazhahui11");
    }

    public void test08(){
        System.out.println("hello wangjing");
    }
}

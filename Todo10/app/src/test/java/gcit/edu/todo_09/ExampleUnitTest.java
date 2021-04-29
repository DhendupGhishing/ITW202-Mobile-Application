package gcit.edu.todo_09;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)

public class ExampleUnitTest {
    private  operation op;
    @Before
    public void setUp(){
        op=new operation();
    }
    @Test
    public void add2(){
        int added=op.add(1,1);
        assertThat(added,equalTo(2));
    }
    @Test
    public void sub2(){
        int sub=op.sub(1,1);
        assertThat(sub,equalTo(0));
    }
    @Test
    public void div2(){
        int div=op.div(1,1);
        assertThat(div,equalTo(1));
    }
    @Test
    public void mul2(){
        int mul=op.mul(1,1);
        assertThat(mul,equalTo(1));
    }

}
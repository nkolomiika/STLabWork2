package org.example;

import org.example.trig.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrigTest {
    private final double EPSILON = 1e-5;

    @Test
    @DisplayName("Test sin(0)")
    public void testSin() {
        assertEquals(Math.sin(0), Sin.calculate(0, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test sin(π/6)")
    public void testSin2() {
        assertEquals(Math.sin(Math.PI / 6), Sin.calculate(Math.PI / 6, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test sin(π)")
    public void testSin3() {
        assertEquals(Math.sin(Math.PI), Sin.calculate(Math.PI, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test sin(-π/3)")
    public void testSin4() {
        assertEquals(Math.sin(-Math.PI / 3), Sin.calculate(-Math.PI / 3, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test sin(-π)")
    public void testSin5() {
        assertEquals(Math.sin(-Math.PI), Sin.calculate(-Math.PI, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test sin(2π)")
    public void testSin6() {
        assertEquals(Math.sin(2 * Math.PI), Sin.calculate(2 * Math.PI, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test sin(-2π)")
    public void testSin7() {
        assertEquals(Math.sin(-2 * Math.PI), Sin.calculate(-2 * Math.PI, EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test cos(0) with stubs")
    public void testCos1WithStubs() {
        Cos cos = new Cos(0);
        assertEquals(Math.cos(0), cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test cos(0.0137) with stubs")
    public void testCos2WithStubs() {
        Cos cos = new Cos(0.01370040599);
        assertEquals(0.9999061, cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test cos(0.0548) with stubs")
    public void testCos3WithStubs() {
        Cos cos = new Cos(0.05477590985);
        assertEquals(0.99849867, cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test cos(-0.0274) with stubs")
    public void testCos4WithStubs() {
        Cos cos = new Cos(-0.02739824028);
        assertEquals(0.99962459, cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test cos(-0.0548) with stubs")
    public void testCos5WithStubs() {
        Cos cos = new Cos(-0.05477590985);
        assertEquals(0.9984986, cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test cos(0.1094) with stubs")
    public void testCos6WithStubs() {
        Cos cos = new Cos(0.10938734658);
        assertEquals(0.99399919, cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test cos(-0.1094) with stubs")
    public void testCos7WithStubs() {
        Cos cos = new Cos(-0.10938734658);
        assertEquals(0.9939991994, cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test cos(0)")
    public void testCos1() {
        double sinX = Sin.calculate(0, EPSILON);
        Cos cos = new Cos(sinX);
        assertEquals(Math.cos(0), cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test cos(π/4)")
    public void testCos2() {
        double sinX = Sin.calculate(Math.PI / 4, EPSILON);
        Cos cos = new Cos(sinX);
        assertEquals(Math.cos(Math.PI / 4), cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test cos(π)")
    public void testCos3() {
        double sinX = Sin.calculate(Math.PI, EPSILON);
        Cos cos = new Cos(sinX);
        assertEquals(0.999999, cos.calculate(), 1e-2);
    }

    @Test
    @DisplayName("Test cos(-π)")
    public void testCos5() {
        double sinX = Sin.calculate(-Math.PI, EPSILON);
        Cos cos = new Cos(sinX);
        assertEquals(0.9984986, cos.calculate(), 1e-2);
    }

    @Test
    @DisplayName("Test cos(2π)")
    public void testCos6() {
        double sinX = Sin.calculate(2 * Math.PI, EPSILON);
        Cos cos = new Cos(sinX);
        assertEquals(Math.cos(2 * Math.PI), cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test cos(-2π)")
    public void testCos7() {
        double sinX = Sin.calculate(-2 * Math.PI, EPSILON);
        Cos cos = new Cos(sinX);
        assertEquals(Math.cos(-2 * Math.PI), cos.calculate(), EPSILON);
    }

    @Test
    @DisplayName("Test tan(π/4)")
    public void testTan1() {
        double sinX = Sin.calculate(Math.PI / 4, EPSILON);
        Cos cos = new Cos(sinX);
        Tan tan = new Tan(sinX, cos.calculate());
        assertEquals(Math.tan(Math.PI / 4), tan.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test tan(-π/6)")
    public void testTan2() {
        double sinX = Sin.calculate(-Math.PI / 6, EPSILON);
        Cos cos = new Cos(sinX);
        Tan tan = new Tan(sinX, cos.calculate());
        assertEquals(Math.tan(-Math.PI / 6), tan.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test tan(0)")
    public void testTan3() {
        double sinX = Sin.calculate(0, EPSILON);
        Cos cos = new Cos(sinX);
        Tan tan = new Tan(sinX, cos.calculate());
        assertEquals(Math.tan(0), tan.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test tan(0.0137) with stubs")
    public void testTan1WithStubs() {
        Tan tan = new Tan(0.01370040599, 0.99990614503);
        assertEquals(0.013701692, tan.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test tan(-0.0091) with stubs")
    public void testTan2WithStubs() {
        Tan tan = new Tan(-0.00913376274, 0.99995828631);
        assertEquals(-0.00913414, tan.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test tan(0) with stubs")
    public void testTan3WithStubs() {
        Tan tan = new Tan(0, 1);
        assertEquals(Math.tan(0), tan.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test cot(π/4)")
    public void testCot1() {
        double sinX = Sin.calculate(Math.PI / 4, EPSILON);
        Cos cos = new Cos(sinX);
        Tan tan = new Tan(sinX, cos.calculate());
        Cot cot = new Cot(tan.calculate(EPSILON));
        assertEquals(1 / Math.tan(Math.PI / 4), cot.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test cot(-π/6)")
    public void testCot2() {
        double sinX = Sin.calculate(-Math.PI / 6, EPSILON);
        Cos cos = new Cos(sinX);
        Tan tan = new Tan(sinX, cos.calculate());
        Cot cot = new Cot(tan.calculate(EPSILON));
        assertEquals(1 / Math.tan(-Math.PI / 6), cot.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test cot(0.0137) with stubs")
    public void testCot1WithStubs() {
        Cot cot = new Cot(0.01370169196);
        assertEquals(72.983687191, cot.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test cot(-0.0091) with stubs")
    public void testCot2WithStubs() {
        Cot cot = new Cot(-0.00913414376);
        assertEquals(-109.4793365883, cot.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test sec(0)")
    public void testSec1() {
        double sinX = Sin.calculate(0, EPSILON);
        Cos cos = new Cos(sinX);
        Sec sec = new Sec(cos.calculate());
        assertEquals(1 / Math.cos(0), sec.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test sec(π/3)")
    public void testSec2() {
        double sinX = Sin.calculate(Math.PI / 3, EPSILON);
        Cos cos = new Cos(sinX);
        Sec sec = new Sec(cos.calculate());
        assertEquals(1 / Math.cos(Math.PI / 3), sec.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test sec(0) with stubs")
    public void testSec1WithStubs() {
        Sec sec = new Sec(1);
        assertEquals(1 / Math.cos(0), sec.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test sec(0.9998) with stubs")
    public void testSec2WithStubs() {
        Sec sec = new Sec(0.99983314875);
        assertEquals(1.00016687, sec.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test csc(π/4)")
    public void testCsc1() {
        double sinX = Sin.calculate(Math.PI / 4, EPSILON);
        Csc csc = new Csc(sinX);
        assertEquals(1 / Math.sin(Math.PI / 4), csc.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test csc(-π/6)")
    public void testCsc2() {
        double sinX = Sin.calculate(-Math.PI / 6, EPSILON);
        Csc csc = new Csc(sinX);
        assertEquals(1 / Math.sin(-Math.PI / 6), csc.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test csc(0.0137) with stubs")
    public void testCsc1WithStubs() {
        Csc csc = new Csc(0.01370040599);
        assertEquals(72.990537, csc.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test csc(-0.0091) with stubs")
    public void testCsc2WithStubs() {
        Csc csc = new Csc(-0.00913376274);
        assertEquals(-109.4839036, csc.calculate(EPSILON), EPSILON);
    }

    @Test
    @DisplayName("Test cot(0) throws ArithmeticException")
    public void testExceptions1() {
        double sinX = Sin.calculate(0, EPSILON);
        Cos cos = new Cos(sinX);
        Tan tan = new Tan(sinX, cos.calculate());
        Cot cot = new Cot(tan.calculate(EPSILON));
        assertThrows(ArithmeticException.class, () -> cot.calculate(EPSILON));
    }

    @Test
    @DisplayName("Test csc(0) throws ArithmeticException")
    public void testExceptions2() {
        double sinX = Sin.calculate(0, EPSILON);
        Csc csc = new Csc(sinX);
        assertThrows(ArithmeticException.class, () -> csc.calculate(EPSILON));
    }
}
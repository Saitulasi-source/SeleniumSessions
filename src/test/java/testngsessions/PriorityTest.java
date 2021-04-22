package testngsessions;

import org.testng.annotations.Test;

public class PriorityTest {

//	@Test(priority = -2)
//	public void a_test() {
//		System.out.println("a test");
//	}
//
//	@Test(priority = 0)
//	public void b_test() {
//		System.out.println("b test");
//	}
//
//	@Test(priority = -1)
//	public void c_test() {
//		System.out.println("c test");
//	}
//
//	@Test
//	public void d_test() {
//		System.out.println("d test");
//	}
//
//	@Test(priority = 1)
//	public void e_test() {
//		System.out.println("e test");
//	}
//
//	@Test
//	public void f_test() {
//		System.out.println("f test");
//	}
//	a test   negative priority
//	c test
//	b test   zero priority
//	d test   non priority
//	f test
//	e test   positive priority
//	PASSED: a_test
//	PASSED: c_test
//	PASSED: b_test
//	PASSED: d_test
//	PASSED: f_test
//	PASSED: e_test

	@Test(priority = 2)
	public void g_test() {
		System.out.println("g test");
	}

	@Test(priority = 0)
	public void h_test() {
		System.out.println("h test");
	}

	@Test
	public void i_test() {
		System.out.println("i test");
	}

	@Test(priority = 1)
	public void j_test() {
		System.out.println("j test");
	}

	@Test
	public void k_test() {
		System.out.println("k test");
	}

//	h test   zero priority
//	i test   non priority
//	k test
//	j test   positive priority
//	g test
//	PASSED: h_test
//	PASSED: i_test
//	PASSED: k_test
//	PASSED: j_test
//	PASSED: g_test
}

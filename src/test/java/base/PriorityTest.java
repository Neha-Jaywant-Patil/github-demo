package base;

import org.testng.annotations.Test;

public class PriorityTest {
 @Test(priority=2)
 public void Atestcase1() {
	System.out.println("This is First test case");
}

@Test
public void Ptestcase2() {
	System.out.println("This is second test case");
}

@Test
public void Mtestcase3() {
	System.out.println("This is Third test case");
}
}

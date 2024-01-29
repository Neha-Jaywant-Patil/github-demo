package base;

import org.testng.annotations.Test;

public class TestNGGroups {
	public class PriorityTest {
		 @Test(priority=1, groups={"sanity"})
		 public void Atestcase1() {
			System.out.println("This is First test case");
		}

		@Test(priority=2, groups={"smoke"})
		public void Ptestcase2() {
			System.out.println("This is second test case");
		}

		@Test(priority=3, groups={"sanity","regression"})
		public void Ntestcase4() {
			System.out.println("This is Fourth test case");
		}
		@Test(priority=2, groups={"smoke","regression"})
		public void Ptestcase5() {
			System.out.println("This is Fith test case");
		}

		@Test(priority=2, groups={"sanity"})
		public void Mtestcase3() {
			System.out.println("This is Third test case");
		}

	}

}
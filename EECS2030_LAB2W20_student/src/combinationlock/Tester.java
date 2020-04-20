package combinationlock;

import static org.junit.Assert.*;
import org.junit.Test;

public class Tester {
	@Test
	public void testcase1()
	{
		ComboLock lock = new ComboLock(5, 15, 30);
		lock.turnRight(5);
		lock.turnLeft(29);
		lock.turnRight(15);
		assertTrue("Failure", lock.open());
	}
	
	@Test
	public void testcase2()
	{
		ComboLock lock = new ComboLock(12, 24, 38);
		lock.turnRight(12);
		lock.turnLeft(27);
		lock.turnRight(14);
		assertTrue("Failure", lock.open());
	}
	
	@Test
	public void testcase3()
	{
		ComboLock lock = new ComboLock(4, 22, 7);
		lock.turnRight(4);
		lock.turnLeft(21);
		lock.turnRight(24);
		assertTrue("Failure", lock.open());
	}
	
	@Test
	public void testcase4()
	{
		ComboLock lock = new ComboLock(36, 1, 23);
		lock.turnRight(36);
		lock.turnLeft(74);
		lock.turnRight(22);
		assertTrue("Failure", lock.open());
	}
	
	@Test
	public void testcase5()
	{
		ComboLock lock = new ComboLock(5, 5, 5);
		lock.turnRight(5);
		lock.turnLeft(39);
		lock.turnRight(39);
		assertTrue("Failure", lock.open());
	}
	
	
}

package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ArrayToTreeTest {
	@Test
	public void testArrayToTree1() {
		Integer[] arr = new Integer[]{1,null,2,null,null,null,3};
		TreeNode root = null;
		try {
			root = ArrayToTree.arrayToTree(arr);
		} catch (Exception e) {
			
			e.printStackTrace();
			return;
		}
		Assert.assertEquals(ArrayToTree.access(root), "123");
	}

	@Test
	public void testArrayToTree() {
		Integer[] arr = new Integer[]{1,2,3,4};
		TreeNode root = null;
		try {
			root = ArrayToTree.arrayToTree(arr);
		} catch (Exception e) {
			
			e.printStackTrace();
			return;
		}
		Assert.assertEquals(ArrayToTree.access(root), "1243");
	}
	
	@Test
	public void testException(){
		Integer[] arr = new Integer[]{1,null,3,4};
		TreeNode root = null;
		String string = null;
		try {
			root = ArrayToTree.arrayToTree(arr);
		} catch (Exception e) {
			
			string = e.getMessage();
		}
		Assert.assertEquals(string, "Element numbered 3  should be null as it's parent is null.");
	}

}

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestSorting {
	
	@Test
	public void test1() {
		MergeSort m = new MergeSort();
		int[] numbers = {2,1,5,6};
		int[] numbersSorted = {1,2,5,6};
		//call the method that will sort the numbers
		m.sort(numbers);
		
	    assertArrayEquals(numbersSorted, numbers);
	}
	
	@Test
	public void test2() {
		MergeSort m = new MergeSort();
		int[] numbers = {2,1,5,6,8,10,9,3};
		int[] numbersSorted = {1,2,3,5,6,8,9,10};
		//call the method that will sort the numbers
		m.sort(numbers);
		
	    assertArrayEquals(numbersSorted, numbers);
	}
	@Test
	public void testHeapSort() {
		HeapSort sort = new HeapSort();
		int arr[] = {3,5,1,2,4};
		int expectation[] = {1,2,3,4,5};
		sort.heapSort(arr);
		assertArrayEquals(expectation, arr);
	}
}

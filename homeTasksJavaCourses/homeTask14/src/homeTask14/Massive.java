package homeTask14;

import homeTask14.NoZeroElementsException;

public class Massive {
	
		public int max(int[] array) {
			int max = array[0];
			for (int i = 0; i < array.length; i++) {
				if (array[i] > max) {
					max = array[i];
				}
			}
			return max;
		}

		public int min(int[] array) {
			int min = array[0];
			for (int i = 0; i < array.length; i++) {
				if (array[i] < min) {
					min = array[i];
				}
			}
			return min;
		}
 
		public int sum(int[] array) {
			int result = 0;
			for (int i = 0; i < array.length; i++) {
				result += array[i];
			}
			return result;
		}

		public int countZeroElements(int[] array) throws NoZeroElementsException {
			int a = 0;
			int count = 0;
			while (a < array.length) {
				if (array[a] == 0) {
					count++;
				}
				a++;
			}
			if (count != 0) {
				return count;
			} else {
				throw new NoZeroElementsException();
			}
		}

		// multiples each element by some number and returns the result array
		public int[] elementsMultiplied(int[] array, int multiplier) {
			for (int i = 0; i < array.length; i++) {
				array[i] = array[i] * multiplier;
			}
			return array;
		}


		public int[] elementsIncreased(int[] array, int incrementer) {
			if (incrementer == 0) {
				return array;
			} else {
				for (int i = 0; i < array.length; i++) {
					array[i] = array[i] + incrementer;
				}
				return array;
			}
		}
}

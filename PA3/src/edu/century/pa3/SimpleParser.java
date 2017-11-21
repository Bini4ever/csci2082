package edu.century.pa3;

public class SimpleParser {
	
	static ArrayStack<Character> store = new ArrayStack<Character>();
	
	/******************************************************
	 * isBalanced method that checks if the file is balanced
	 * @param expression
	 * @return
	 */
	public static boolean isBalanced(String expression){
		final char LEFT_NORMAL = '(';
		final char RIGHT_NORMAL = ')';
		final char LEFT_CURLY = '{';
		final char RIGHT_CURLY = '}';
		final char LEFT_SQUARE = '[';
		final char RIGHT_SQUARE = ']';
		final char LEFT_ANGLE = '<';
		final char RIGHT_ANGLE = '>';
		
		int i;
		boolean failed = false;
		
		for(i = 0; !failed && (i < expression.length()); i++){
			
			switch (expression.charAt(i)){
			case LEFT_NORMAL:
			case LEFT_CURLY:
			case LEFT_SQUARE:
			case LEFT_ANGLE:
				store.push(expression.charAt(i));
				break;
			case RIGHT_NORMAL:
				if (store.empty() || (store.pop() != LEFT_NORMAL)){
					failed = true;
				}
				break;
			case RIGHT_CURLY:
				if (store.empty() || (store.pop() != LEFT_CURLY)){
					failed = true;
				}
				break;
			case RIGHT_SQUARE:
				if (store.empty() || (store.pop() != LEFT_SQUARE)){
					failed = true;
				}
				break;
			case RIGHT_ANGLE:
				if (store.empty() || (store.pop() != LEFT_ANGLE)){
					failed = true;
				}
				break;
			}
		}
		
	
		return (store.empty() && !failed);
	}
	
	/*************************************************
	 * missing method that return the missing characters
	 * @return
	 */
	public static String missing(){
		String missing = "";
		while (!store.empty()){
			missing += store.pop();
			missing += " ";
		}
		return missing;
	}
	
}

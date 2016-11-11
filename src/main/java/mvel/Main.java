package mvel;

import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	public static void main(String [] args) {
		String myExpression = "value1 + value2";
		Integer result = calculate(myExpression);
		System.out.println("The result of expression [" + myExpression + "] is: " + result);

		myExpression = "value1 + (value2 * 2)";
		result = calculate(myExpression);
		System.out.println("The result of expression [" + myExpression + "] is: " + result);

		myExpression = "value1 * value2";
		result = calculate(myExpression);
		System.out.println("The result of expression [" + myExpression + "] is: " + result);
	}

	public static Integer calculate(String expression) {
		Map<String, Integer> values = new LinkedHashMap<String, Integer>();
		values.put("value1", 2);
		values.put("value2", 3);
		final Serializable str = MVEL.compileExpression(expression);
		return (Integer) MVEL.executeExpression(str, values);
	}
}

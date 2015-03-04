package T10;
/*
 * Stack-based big number addition*/
public class BigNumberAddition {
	public static void main(String[] args) {

		String num1 = "142896796867858656778668";
		String num2 = "239749734434565464757678678";

		LinkedStack<String> stack1 = new LinkedStack<>();
		LinkedStack<String> stack2 = new LinkedStack<>();
		LinkedStack<String> stack3 = new LinkedStack<>();

		for (int i = 0; i < num1.length(); i++) {
			stack1.push(num1.charAt(i) + "");
		}
		for (int j = 0; j < num2.length(); j++) {
			stack2.push(num2.charAt(j) + "");
		}

		int tmp = 0;
		while (!stack1.empty() && !stack2.empty()) {
			int subresult = Integer.parseInt(stack1.pop())
					+ Integer.parseInt(stack2.pop()) + tmp;
			if (subresult < 10) {
				stack3.push(Integer.toString(subresult));
				tmp = 0;
			} else {
				stack3.push(Integer.toString(subresult - 10));
				tmp = 1;
			}

		}

		while (!stack1.empty()) {
			int subresult = Integer.parseInt(stack1.pop()) + tmp;
			if (subresult < 10) {
				stack3.push(Integer.toString(subresult));
				tmp = 0;
			} else {
				stack3.push(Integer.toString(subresult - 10));
				tmp = 1;
			}
		}

		while (!stack2.empty()) {
			int subresult = Integer.parseInt(stack2.pop()) + tmp;
			if (subresult < 10) {
				stack3.push(Integer.toString(subresult));
				tmp = 0;
			} else {
				stack3.push(Integer.toString(subresult - 10));
				tmp = 1;
			}
		}

		while (!stack3.empty()) {
			System.out.printf(stack3.pop());
		}
	}

}

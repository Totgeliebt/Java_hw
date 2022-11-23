package HW_1;

public class task_1 {
    public static void main(String[] args) throws Exception {
        System.out.println(showTotalAmount(5));
        System.out.println(calculateFactorial(4)); 
    }
    
    public static String showTotalAmount(int value) {
        int result = 0;
        for (int i = 1; i <= value; i++) {
            result += i;
        }
        return String.valueOf(result);
    }
    static int calculateFactorial(int n){
		int result = 1;
		for (int i = 1; i <=n; i ++){
			result = result*i;
		}
		return result;
	}
}

package HW_1;

public class task_2{
	
	public static void main(String[] args) {
    
        boolean b = true;
        for (int P = 2; P <= 1000; P++) {
            for (int i = 2; i < P; i++) {
                if (P % i == 0) {
                    b = false;
                    break;
                }
            }
            if (b) System.out.println(P);
            else b = true;
        }
    }
   
}

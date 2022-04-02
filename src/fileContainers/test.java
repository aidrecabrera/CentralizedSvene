package fileContainers;

public class test {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[5];
        try {
            System.out.println("Try 1");
            nums[10] = 25;
            System.out.println("Try 2");
        } finally {
            System.out.println("Bye!");
        }
    }
}

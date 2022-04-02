package fileContainers;

public class test {
    public static void main(String[] args) {
        int[] nums = new int[5];
        try {
            System.out.println("Try 1");
            nums[10] = 25;
            System.out.println("Try 2");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Catch 1");
        } catch (Exception ex) {
            System.out.println("Catch 2");
        }
    }
}

package core;


public class Runner {
    public static void runZoned(Runnable execution, String text) {
        System.out.println("\n##### START " + text + " #####\n");
        execution.run();
        System.out.println("\n##### END " + text + " #####\n");
    }
}

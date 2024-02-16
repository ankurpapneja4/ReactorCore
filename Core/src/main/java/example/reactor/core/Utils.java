package example.reactor.core;

public class Utils {

    public static void await(long millis){
        try { Thread.sleep( 2000); } catch (InterruptedException exp) { exp.printStackTrace(); } }
}

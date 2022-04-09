package homework3;

public class Main {
    public static final int COUNT = 3;
    public static void main(String[] args) throws InterruptedException {
        MyRunnableTwo myRunnableTwo = new MyRunnableTwo();
        new Thread(null, myRunnableTwo::call, "пользователь").start();
        Thread.sleep(3000);//TODO , тк если убрать слип, тогда при захвате другими потоками коллекции,
        //todo они видят там нал и выходя
        for (int i = 1; i <= COUNT; i++) {
            new Thread(null,myRunnableTwo::answer,"оператор "+ i).start();
        }
    }

}

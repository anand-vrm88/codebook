package interview.otherinterview.intuit;


class DemoSingleton {

    private static DemoSingleton instance;

    private DemoSingleton() {
    }

    public static DemoSingleton getInstance() {
        synchronized (DemoSingleton.class) {
            synchronized (DemoSingleton.class) {
                if (instance == null) {
                    instance = new DemoSingleton();
                }
            }
        }
        return instance;
    }
}

class Demo {

    public static void main(String[] args) {
        DemoSingleton instance = DemoSingleton.getInstance();
    }
}

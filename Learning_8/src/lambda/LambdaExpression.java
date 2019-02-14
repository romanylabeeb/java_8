package lambda;

import java.util.function.BiConsumer;

public class LambdaExpression {


    public static void main(String... args) {
        try {

            LambdaExpression lambdaExpression = new LambdaExpression();
        Thread th1 =lambdaExpression.getThreadUsingAnonymousClass("anonymous",4);
        Thread t2=lambdaExpression.getThreadUsingLambda("lambda   ",12);
            t2.join();
            t2.start();
            th1.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Thread getThreadUsingAnonymousClass(final String threadName,final int count) {

        return new Thread(new Runnable() {
            @Override
            public void run() {
                runCode(threadName,count);
            }
        });

    }


    public Thread getThreadUsingLambda(final String threadName,final int count) {
        BiConsumer<String ,Integer>c=LambdaExpression::runCode;
        return  new Thread(()->c.accept(threadName,count));
    }
    private static  void runCode(String threadName,int n){
        for(int i=1;i<=n;i++){
            System.out.println("thread:" +threadName+",\ti:"+i);
        }
    }
}

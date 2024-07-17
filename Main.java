public class Main
{
    public static void main(String[] args)
    {
        long startTime = System.nanoTime();
        int num =11;
        if(num%2==0)
        {
            System.out.println("even");
        }
        else
        {
            System.out.println("even");
        }

        long endTime = System.nanoTime();
        var elapsedTime = (endTime - startTime)* Math.pow(Math.E,-9);
        System.out.println(elapsedTime+ " seconds");
    }
}
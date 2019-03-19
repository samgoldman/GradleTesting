public class Utilities {

    /**
     * Returns the answer to life, the universe and everything
     * @return the answer
     */
    public static int getAnswer() {
        return 42;
    }

    /**
     * Think before answering
     * @return the answer
     */
    public static int thinkBeforeAnswering() {
        long start = System.nanoTime();
        while (System.nanoTime() - start < 30_000_000_000L) {
            // Wait 30 seconds
        }

        return getAnswer();
    }
}

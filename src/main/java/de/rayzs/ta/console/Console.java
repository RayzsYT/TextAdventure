package de.rayzs.ta.console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Console {

    private static boolean RUNNING = true, USE_CONSOLE = true;
    private static final Executor EXECUTOR = Executors.newCachedThreadPool();

    static {
        EXECUTOR.execute(() -> {
            while (RUNNING) {
                if(!USE_CONSOLE) continue;

                try {
                    String input = new BufferedReader(new InputStreamReader(System.in)).readLine();

                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
    }

    public static void i(String message, String... replacements) {
        String finalMessage = message;

        if (finalMessage.contains("%s")) {
            String[] splitMessage = message.split("%s");
            finalMessage = "";
            for (int i = 0; i < splitMessage.length; i++)
                finalMessage += splitMessage[i] + replacements[i];
        }

        System.out.println(finalMessage);
    }

    public static void clear(){
        try {
            if (System.getProperty("os.name").contains("Windows")) new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else Runtime.getRuntime().exec("clear");

        } catch (Throwable ignored) { }
    }
}
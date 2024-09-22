import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            System.out.println("Введите что вы хотите сделать:\n 1 - запустить процесс по названию\n 2 - закрыть процесс по PIDу\n 3 - Вывести всю инфу по процессам\n");
            Scanner scanner = new Scanner(System.in);
            int action = scanner.nextInt();
            switch (action){
                case 1 -> {
                        System.out.print("Введите название процесса с расширением: ")
                    ;
                    String app = scanner.next();
                    ProcessBuilder pb = new ProcessBuilder(app);
                    Process pr = pb.start();
                    Thread.sleep(3000);
                    Runtime.getRuntime().exec("taskkill /F /T /IM " + app);
                    System.out.println("Процесс запущен и уничтожен через 3 секунды");
                    }
                case 2 -> {
                    System.out.print("Введите ПИД процесса: ");
                    String PID = scanner.next();
                    Runtime.getRuntime().exec("taskkill /F /T /PID " + PID);
                    System.out.println("Процесс изничтожен");
                }
                case 3 -> {
                    String line;
                    Process p = Runtime.getRuntime().exec
                            (System.getenv("windir") + "\\system32\\" + "tasklist.exe");
                    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    while ((line = input.readLine()) != null) {
                        System.out.println(line);
                    }
                    input.close();
                }




            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    }


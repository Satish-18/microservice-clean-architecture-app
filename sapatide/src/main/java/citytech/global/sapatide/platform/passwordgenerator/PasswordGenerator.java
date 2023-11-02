package citytech.global.sapatide.platform.passwordgenerator;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Random;

public class PasswordGenerator {
    public static String generate() {
        Dotenv dotEnv =Dotenv.load();
        String characters = dotEnv.get("PASSWORD_GENERATOR_KEY");
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int length = 7;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}

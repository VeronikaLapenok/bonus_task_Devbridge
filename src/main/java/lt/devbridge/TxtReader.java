package lt.devbridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtReader {
    private static final Logger LOG = LoggerFactory.getLogger(TxtReader.class.getName());

    public static void readTxtFile(String path) {
        Pattern pattern = Pattern.compile("[1-9][0-9]+");
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines().forEach(line -> {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    LOG.debug(line);
                }
            });
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readTxtFile(args[0]);
    }
}

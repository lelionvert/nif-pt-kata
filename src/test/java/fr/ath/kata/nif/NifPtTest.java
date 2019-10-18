package fr.ath.kata.nif;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class NifPtTest {

    @Test
    public void validaContribuinte() throws IOException {
        NifPt nifPt = new NifPt() {
            @Override
            public void showError() {

            }
        };
        String fileName = "C:\\Git\\nif-pt-kata-master\\java\\src\\test\\resources\\results.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> {
                String[] split = line.split(":");
                String input = split[0];
                String output = split[1];

                Assertions.assertThat(nifPt.getTemErro(input)).isEqualTo(Integer.parseInt(output));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
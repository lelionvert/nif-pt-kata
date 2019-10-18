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

public class NifPtTest {

    @Test
    public void validaContribuinte() throws IOException {
        NifPt nifPt = new NifPt() {
            @Override
            public void showError() {

            }
        };

        Random r = new Random();

        int temErro = 0;
        List<String> lines = new ArrayList<String>();
        for (int i=0; i<1_000_000; i++) {
            int randomNumber = r.nextInt((999_999_999 - 100_000_000) + 1) + 100_000_000;
            temErro = nifPt.getTemErro(String.valueOf(randomNumber));;
            lines.add("" + randomNumber + ":" + temErro);
        }

        Path write = Files.write(
                Paths.get("C:\\Git\\nif-pt-kata-master\\java\\src\\test\\resources\\results.txt"),
                lines,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
        Assertions.assertThat(temErro).isEqualTo(1);
    }
}
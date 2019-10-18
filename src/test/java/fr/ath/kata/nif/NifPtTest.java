package fr.ath.kata.nif;

import org.junit.Test;

import static org.junit.Assert.*;

public class NifPtTest {

    @Test
    public void validaContribuinte() {
        NifPt nifPt = new NifPt() {
            @Override
            public void showError() {

            }
        };
        nifPt.validate("222222222");
    }
}
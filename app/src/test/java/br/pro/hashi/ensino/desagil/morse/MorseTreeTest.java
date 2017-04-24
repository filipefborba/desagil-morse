package br.pro.hashi.ensino.desagil.morse;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class MorseTreeTest {
    private MorseTree tree;
    List<String> morseToTextList = new ArrayList<String>();

    @Before
    public void setUp() {
        tree = new MorseTree();
        morseToTextList.clear();
    }

    @Test
    public void checkA() {
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String a = tree.translate(morseToTextList);
        assertEquals("a", a);
    }

    @Test
    public void checkB() {
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String b = tree.translate(morseToTextList);
        assertEquals("b", b);
    }

    @Test
    public void checkC() {
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String c = tree.translate(morseToTextList);
        assertEquals("c", c);
    }

    @Test
    public void checkD() {
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String d = tree.translate(morseToTextList);
        assertEquals("d", d);
    }

    @Test
    public void checkE() {
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String e = tree.translate(morseToTextList);
        assertEquals("e", e);
    }

    @Test
    public void checkF() {
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String f = tree.translate(morseToTextList);
        assertEquals("f", f);
    }

    @Test
    public void checkG() {
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String g = tree.translate(morseToTextList);
        assertEquals("g", g);
    }

    @Test
    public void checkH() {
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String h = tree.translate(morseToTextList);
        assertEquals("h", h);
    }

    @Test
    public void checkI() {
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String i = tree.translate(morseToTextList);
        assertEquals("i", i);
    }

    @Test
    public void checkJ() {
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String j = tree.translate(morseToTextList);
        assertEquals("j", j);
    }

    @Test
    public void checkK() {
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String k = tree.translate(morseToTextList);
        assertEquals("k", k);
    }

    @Test
    public void checkL() {
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String l = tree.translate(morseToTextList);
        assertEquals("l", l);
    }

    @Test
    public void checkM() {
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String m = tree.translate(morseToTextList);
        assertEquals("m", m);
    }

    @Test
    public void checkN() {
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String n = tree.translate(morseToTextList);
        assertEquals("n", n);
    }

    @Test
    public void checkO() {
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String o = tree.translate(morseToTextList);
        assertEquals("o", o);
    }

    @Test
    public void checkP() {
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String p = tree.translate(morseToTextList);
        assertEquals("p", p);
    }

    @Test
    public void checkQ() {
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String q = tree.translate(morseToTextList);
        assertEquals("q", q);
    }

    @Test
    public void checkR() {
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String r = tree.translate(morseToTextList);
        assertEquals("r", r);
    }

    @Test
    public void checkS() {
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String s = tree.translate(morseToTextList);
        assertEquals("s", s);
    }

    @Test
    public void checkT() {
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String t = tree.translate(morseToTextList);
        assertEquals("t", t);
    }

    @Test
    public void checkU() {
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String u = tree.translate(morseToTextList);
        assertEquals("u", u);
    }

    @Test
    public void checkV() {
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String v = tree.translate(morseToTextList);
        assertEquals("v", v);
    }

    @Test
    public void checkW() {
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String w = tree.translate(morseToTextList);
        assertEquals("w", w);
    }

    @Test
    public void checkX() {
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String x = tree.translate(morseToTextList);
        assertEquals("x", x);
    }

    @Test
    public void checkZ() {
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String z = tree.translate(morseToTextList);
        assertEquals("z", z);
    }

    @Test
    public void check1() {
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String one = tree.translate(morseToTextList);
        assertEquals("1", one);
    }

    @Test
    public void check2() {
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String two = tree.translate(morseToTextList);
        assertEquals("2", two);
    }

    @Test
    public void check3() {
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String three = tree.translate(morseToTextList);
        assertEquals("3", three);
    }

    @Test
    public void check4() {
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String four = tree.translate(morseToTextList);
        assertEquals("4", four);
    }

    @Test
    public void check5() {
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String five = tree.translate(morseToTextList);
        assertEquals("5", five);
    }

    @Test
    public void check6() {
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String six = tree.translate(morseToTextList);
        assertEquals("6", six);
    }

    @Test
    public void check7() {
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String seven = tree.translate(morseToTextList);
        assertEquals("7", seven);
    }

    @Test
    public void check8() {
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String eight = tree.translate(morseToTextList);
        assertEquals("8", eight);
    }

    @Test
    public void check9() {
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(".");
        morseToTextList.add(" ");
        String nine = tree.translate(morseToTextList);
        assertEquals("9", nine);
    }

    @Test
    public void check0() {
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add("-");
        morseToTextList.add(" ");
        String zero = tree.translate(morseToTextList);
        assertEquals("0", zero);
    }
}

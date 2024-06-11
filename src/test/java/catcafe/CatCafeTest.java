package catcafe;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CatCafeTest {

    @Test
    void addCat() {
        CatCafe c = new CatCafe();
        FelineOverLord testCat = new FelineOverLord("Whiskers", 3);
        c.addCat(testCat);
        assertEquals(1, c.getCatCount());
    }
    @Test
    void addCat_multipleCats() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr", 3);
        FelineOverLord testPurr = new FelineOverLord("Purr", 5);
        c.addCat(testPurr);
        c.addCat(testSchnurr);
        assertEquals(2, c.getCatCount());
    }
    @Test
    void getCatCount_count0() {
        CatCafe c = new CatCafe();
        assertEquals(0, c.getCatCount());
    }
    @Test
    void getCatCount_count2() {
        CatCafe c = new CatCafe();
        c.addCat(new FelineOverLord("a",1));
        c.addCat(new FelineOverLord("b",2));
        assertEquals(2,c.getCatCount());
    }
    @Test
    void getCatByName_findName() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr",1);
        c.addCat(testSchnurr);
        assertEquals(Optional.of(testSchnurr),c.getCatByName("Schnurr"));
    }
    @Test
    void getCatByName_findEmpty() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr",1);
        assertEquals(Optional.empty(),c.getCatByName("Schnurr"));
    }
    @Test
    void getCatByName_nameNull() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr",1);
        c.addCat(testSchnurr);
        assertEquals(Optional.empty(),c.getCatByName(null));
    }
    @Test
    void getCatByName_treeEmpty() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr",1);
        assertEquals(Optional.empty(),c.getCatByName("Schnurr"));
    }
    @Test
    void getCatByWeight_minLess0() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr",1);
        c.addCat(testSchnurr);
        assertEquals(Optional.empty(),c.getCatByWeight(-1,3));
    }
    @Test
    void getCatByWeight_boundsOff() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr",1);
        c.addCat(testSchnurr);
        assertEquals(Optional.empty(),c.getCatByWeight(5,2));
    }
    @Test
    void getCatByWeight_empty() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr",1);
        assertEquals(Optional.empty(),c.getCatByWeight(5,2));
    }
    @Test
    void getCatByWeight_noMatch() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr",5);
        FelineOverLord testPurr = new FelineOverLord("Purr",10);
        c.addCat(testPurr);
        c.addCat(testSchnurr);
        assertEquals(Optional.empty(),c.getCatByWeight(1,4));
    }
    @Test
    void getCatByWeight_match() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr",5);
        FelineOverLord testPurr = new FelineOverLord("Purr",10);
        c.addCat(testPurr);
        c.addCat(testSchnurr);
        assertEquals(Optional.of(testSchnurr),c.getCatByWeight(1,10));
    }
    @Test
    void getCatByWeight_matchOrder() {
        CatCafe c = new CatCafe();
        FelineOverLord testSchnurr = new FelineOverLord("Schnurr",5);
        FelineOverLord testPurr = new FelineOverLord("Purr",10);
        c.addCat(testPurr);
        c.addCat(testSchnurr);
        assertNotEquals(Optional.of(testPurr),c.getCatByWeight(1,10));
    }
}

package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void otaRahaaToimiiHyvallaSyotteella(){
        kortti.otaRahaa(5);
        assertEquals(5, kortti.saldo());
        
    }
    
    @Test
    public void otaRahaaEiMeneNegatiiviseksi(){
        kortti.otaRahaa(5);
        kortti.otaRahaa(10);
        assertEquals(5, kortti.saldo());
        
    }
    
    @Test 
    
    public void lataaRahaaToimii(){
        kortti.lataaRahaa(5);
        assertEquals(15, kortti.saldo());
    }
    
    @Test
    public void toStringToimii(){
        kortti.lataaRahaa(2);
        assertEquals("saldo: 0.12", kortti.toString());
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miika
 */
public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void alkuRahaOikein(){
        
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test
    public void alkuLounaatOikein(){
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoEdullisestiKasvattaaKassaa(){
        kassa.syoEdullisesti(300);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void kateisostoEdullisestiVaihtorahaOikein(){
        int vaihtoraha = kassa.syoEdullisesti(300);
        assertEquals(60,vaihtoraha);
    }
    
    @Test
    public void kateisostoEdullisestiKasvattaaLounaita(){
        kassa.syoEdullisesti(300);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    
    @Test
    public void kateisostoEdullisestiRahaEiRiitaKassa(){
        kassa.syoEdullisesti(100);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kateisostoEdullisestiRahaEiRiitaVaihtoraha(){
        int vaihtoraha = kassa.syoEdullisesti(100);
        assertEquals(100, vaihtoraha);
    }
    
    @Test
    public void kateisostoEdullisestiRahaEiRiitaLounaatEiMuutu(){
        kassa.syoEdullisesti(100);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    
    @Test
    public void kateisostoMaukkaastiKasvattaaKassaa(){
        kassa.syoMaukkaasti(450);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void kateisostoMaukkaastiVaihtorahaOikein(){
        int vaihtoraha = kassa.syoMaukkaasti(450);
        assertEquals(50,vaihtoraha);
    }
    
    @Test
    public void kateisostoMaukkaastiKasvattaaLounaita(){
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    
    @Test
    public void kateisostoMaukkaastiRahaEiRiitaKassa(){
        kassa.syoMaukkaasti(100);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kateisostoMaukkaastiRahaEiRiitaVaihtoraha(){
        int vaihtoraha = kassa.syoMaukkaasti(300);
        assertEquals(300, vaihtoraha);
    }
    
    @Test
    public void kateisostoMaukkaastiRahaEiRiitaLounaatEiMuutu(){
        kassa.syoMaukkaasti(100);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoEdullisestiRahaRiittaaKassaKasvaa(){
        boolean maksu = kassa.syoEdullisesti(kortti);
        assertEquals(true, maksu);
        
    }
    
    @Test
    public void korttiOstoEdullisestiKasvattaaMyytyja(){
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    
    @Test 
        public void korttiOstoEdullisestiRahaEiRiitaRahaaEiVeloiteta(){
        kortti.otaRahaa(900);
        boolean maksu = kassa.syoEdullisesti(kortti);
        assertEquals(false, maksu);
    }
    
    
    @Test
    public void korttiOstoMaukkaastiRahaRiittaaKassaKasvaa(){
        boolean maksu = kassa.syoMaukkaasti(kortti);
        assertEquals(true, maksu);
        
    }
    
    @Test
    public void korttiOstoMaukkaastiKasvattaaMyytyja(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoEiKasvataKassaa (){
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test 
        public void korttiOstoMaukkaastiRahaEiRiitaRahaaEiVeloiteta(){
        kortti.otaRahaa(900);
        boolean maksu = kassa.syoMaukkaasti(kortti);
        assertEquals(false, maksu);
    }
        
        
    @Test
        public void lataaKorttiaKorttiLatautuu(){
            kassa.lataaRahaaKortille(kortti, 1000);
            assertEquals(2000, kortti.saldo());
        }
        
    @Test
        public void lataaKorttiaKassaKasvaa(){
            kassa.lataaRahaaKortille(kortti, 1000);
            assertEquals(101000, kassa.kassassaRahaa());
        }    
    
    @Test 
       public void lataaKorttiaNegatiivinenEiToimi(){
           kassa.lataaRahaaKortille(kortti, -1000);
           assertEquals(100000, kassa.kassassaRahaa());
       }
}

# Testausdokumentti
Kokonaiskattavuus testauksessa oli varsin hyvä
![kokonaiskattavuus](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/testikattavuus/overal.jpg)

## Yksikkötestaus
![primaryviewmodleit](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/testikattavuus/primaryview.jpg)

PrimaryView pakkauksesta yksikkötestauksen osalta testettiin kattavasti Player ja Score luokkien metodeja.

![gamemodelitestit](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/testikattavuus/game.jpg)

Game pakkauksesta yksikkö testattiin luokkaa Cell, Location, Grocery.

![database kattavuus](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/testikattavuus/database.jpg)
Database pakkauksesta testattiin PlayerDao luokan toimintaa. Luokan testauskattavuutta laskee valitettavasti testien puute virhetapausten (Exception) varalle. 

## Integraatiotestaus
Koska GroceryList on varsin riippuvainen Grocery luokasta niin luokan GroceryList testit myös integraatiotestasivat GroceryList ja Grocery luokkien yhteistoimintaa.

Player ja Score luokkien yhteistoimintaa testattiin testissä PlayerScoreTest.java. 

GameGrid luokka on riippuvainen luokista Player, Location, GroceryList, joten sen testaaminen käytännössä oli näitten luokkien integraatiotestausta. 

## Järjestelmätestaus
![jarjestelmatestikva](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/testikattavuus/jarjestelmatesti.jpg)

Järjestelmätason testaaminen tehtiin luomalla peliskenaario testissä "GameTest". Alussa pelaajan ostoslistalla on esineet "Chocolate", "Chicken", "Soap" (huom! kuva virheellinen tässä mielessä). 

Testin ensmmäisessä vaiheessa siirretään pelaaja pisteeseen yksi, jolloin ostoslistalta tulisi poistua suklaa. 

Toisessa vaiheessa pelaaja siirretään samaa reittiä pitkin kohtaan 2, jolloin kanan tulisi poistua ostoslistalta. 

Kolmannessa vaiheessa pelaaja jatkaa matkaa kodintavarat hyllylle ja saippua poistuu ostoslistalta. 

Viimeisessä vaiheessa pelaaja siirtyy kassalle ja testataan, että peli loppui. 

Kaikissa eri osuuksissa testataan, että pelaajan pistemäärä on siihen mennessä tapahtuneeseen suoritukseen nähden oikea. 


## Testien puutteet

Testaus jää valitettavaati puutteelliseksi tietokantaoperaatioiden virheiden varalta luokassa PlayerDao.

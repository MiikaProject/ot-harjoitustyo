# Arkkitehtuurikuvaus

## Rakenne
Ohjelmisto pyrkii noudatttamaan MVC arkkitehtuuria (Model-View-Controller). 

Tässä mallissa View vastaa asian graafisesta esityksestä käyttäjälle, Model vastaa itse soveluuslogiikasta ja Controller toimii siltana käyttöliittymän ja sovelluslogiikan välillä.



Pakkausrakenteessa ohjelmassa on 4 pääpakkausta:
* Primaryview, joka käsittää ensimmäisen ikkunan peliin siirtyessä, jossa pelaaja voi syöttää nimensä ja valitun vaikeustason
* Game, näkymä jossa itse pelin pelaaminen tapahtuu
* GameOver, joka käsittelee pelin loppumisen jälkeisiä tapahtumia
* Database, joka käsittelee tietokannan toteutukseen liittyvät osat sovelluksesta.

Jokainen pakkaus sisältää alikansiot vieweille, controllereille ja modeleille. Paitsi database ei sisällä em. alikansioita.

![primaryview pakkauskaavio](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/primariviewpakkauskaavio.png)

![gameview pakkauskaavio](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/gamepakkauskaavio.png)

![gameoverview pakkauskaavio](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/gameoverpakkausrakenne.png)

![database pakkauskaavio](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/databasepakkauskaavio.png)

## Sovelluslogiikka

![luokkakaavio](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/luokkakaavioGameGrid.png)

Sovelluksen keskiössä on luokka GameGrid. GameGrid on 20x20 ruudukko. Jokaista ruutua kuvaa luokka Cell. Cell sisältää muuttujan "type", joka kuvaa solun tyyppiä. Oletustyyppi on tyhjä. Solulle voidaan antaa tyypiksi esimerkiksi maitohylly, pakasteallas yms. Ruudukon soluista yksi on tyypiltään "shopper", joka kuvaa pelaajaa. 

GameGrid sisältää metodit moveShopperRight, MoveShopperLeft, MoveShopperUp,MoveShopperDown, joiden avulla voidaan siirtää pelaajaa eri suuntiin. Yksi komento siirtää pelaajaa yhden solun verran haluttuun suuntaan. Tällöin solu, jossa pelaaja oli muutetaan taas tyypiltään tyhjäksi ja solu johon pelaaja siirtyy muutetaan tyypiltään "shopperiksi". 

Ennen liikkumista tiettyyn suuntaan tarkistetaan, että ruutu johon halutaan liikkua sijaitsee ruudukossa. Lisäksi kutsutaan metodia IsShelf(int y, int x), jolla tarkistetaan, onko ruutu johon halutaan siirtyä tyypiltään joku hyllyistä. Jos ruutu on hylly niin pelaaja ei voi liikkua sen päälle, vaan kutsutaan metodia InteractWithCell(y,x), jolloin suoritetaan interaktio hyllyn ja pelaajan välillä.

GameGrid sisältää luokan GroceryList. GroceryList luokka sisältää listan ostoksia, joita kuvaa luokka Grocery. Jokaisella ostoksella on nimi ja kategoria (esim. maitotuote, liha, pakaste). InteractWithCell tarkistaa onko pelaajan ostoslistalla esine, joka kuuluu kyseiseen hyllyyn ja poistaa sen ostoslistalta.

Jos pelaajan ostoslista on tyhjä ja hän yrittää liikkua kassa (cashier) tyyppiseen soluun, peli loppuu.
## Päätoiminnallisuudet


### Uuden pelaajan luominen ja peliin siirtyminen
![kuva pelaajan luomisesta](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/sekvenssikaavio.png)


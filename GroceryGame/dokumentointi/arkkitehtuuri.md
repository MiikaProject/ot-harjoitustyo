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


## Päätoiminnallisuudet

### Uuden pelaajan luominen ja peliin siirtyminen
![kuva pelaajan luomisesta](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/sekvenssikaavio.png)


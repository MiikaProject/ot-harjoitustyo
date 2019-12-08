# Käyttöohje
Siirry hakemistossa GroceryGame juureen.

## Ohjelman käynnistäminen
Ohjelma käynnistetään lataamalla projekti IDE ja suorittamalla se sitä kautta tai komentoriviltä komennolla "mvn compile exec:java -Dexec.mainClass=grocerygame.Main". Vaatimuksena komentoriviltä suorittamiseen on Mavenin asentaminen komentoriviltä suoritettavaksi.

## Pelin aloittaminen
![alkuvalikko](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/alkuvalikko.png)

Aloittaaaksesi pelin sinun tulee syöttää nimimerkkisi ja valita haluamasia vaikeustaso. Nimimerkittä ei voi pelata peliä ja tämä johtaa pyyntöön syöttää nimimerkki. Vaikeustaso tulee myös valita päästäksesi pelii. Vaikeustasolla I tulee kerätä 3 esinettä, vaikeustasolla II 5 esinettä ja vaikeustasolla III 7 esinettä.

Aloitusvalikon vasemmalla puolella näkyy 5 eniten pisteitä saavuttanutta pelaajaa. 

## Pelin pelaaminen
![pelinäkymä](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/pelinakyma.png)

Pelin tarkoituksena on kerätä 30 sekunnissa mahdollisimman monta esinettä oikealla alhaalla näkyvästä ostoslistasta (grocerylist). Jokaisen esineen keräämisestä saa 50 pistettä. Kun olet kerännyt kaikki listalta olevat esineet, sinun tulee mennä kassalle(cashier), joka on vasemmassa alakulmassa oleva musta laatikko. Kassalle ehtisimisestä saa 100 lisäpistettä. Jos sinulle jää ylimääräistä aikaa saat jokasesta sekunnista lisääpisteitä. Lisäpisteet lasketaan kaavalla ylimääräinen aika x vaikeustaso.


## Pelin loppu
![loppunäkymä](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/kuvat/loppunakyma.png)






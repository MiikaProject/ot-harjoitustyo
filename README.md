#  Ohjelmistotekniikka 2019 syksy

## KauppaPeli
Ohjelman tarkoituksena on muodostaa peli, jossa pelaajan tulee ohjata hahmoa kaupassa ja kerätä mahdollisimman nopeasti ostoslistalla olevat esineeet.


## Dokumentaatio
* [Vaatimusmäärittely](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/vaatimusmaarittely.md)
* [Tuntikirjanpito](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/tuntikirjanpito.md)
* [Arkkitehtuuri](https://github.com/MiikaProject/ot-harjoitustyo/blob/master/GroceryGame/dokumentointi/arkkitehtuuri.md)

## Releaset
[viikko 5](https://github.com/MiikaProject/ot-harjoitustyo/releases/download/viikko5/GroceryGame1.0.jar)

## Komentorivi komennot
Ennen komentorivien suorittamista tulee siirtyä Maven-projektin juureen eli ot-harjoitustyo/Grocerygame

### Testaus
yleinen testaus
```
mvn test
```
### testaus kattavuus raportti
```
mvn test jacoco:report
```
### Ohjelman käynnistys 
```
mvn compile exec:java -Dexec.mainClass=grocerygame.Main
```
### Checkstyle raportti
```
mvn jxr:jxr checkstyle:checkstyle
```
### Jar generointi
```
mvn package
```



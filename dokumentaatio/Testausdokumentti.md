# Testausdokumentti

## Testikattavuus

![TestikattavuusTiralabra](https://user-images.githubusercontent.com/62248076/96376983-cb5d9900-118a-11eb-84c0-703b8dabadea.png)

Testikattavuuden ulkopuolelle on jätetty luokat Freimi, Grafiikat ja Ui.

## Labyrinttien vertailu

Ohjelmassa vertaillaan Primin algoritmillä ja peruuttavalla haulla luotuja 
labyrinttejä keskenään. Labyrintin generoitua, voidaan leveys- tai syvyyshaulla saada 
labyrintin vasemmasta yläkulmasta oikeaan alakulmaan kulkevan reitin pituus.
Generoin 1000000 100x100 labyrinttiä Peruuttavalla haulla, sekä Primin algoritmillä, 
ja vertailin reittien pituuksia keskenään. Peruuttalla haulla generoiduissa labyrinteissä
lyhyin reitti vasemmasta yläkulmasta oikeaan alakulmaan oli lähes aina huomattavasti pidempi kuin Primin
algoritmillä generoiduissa.

Huomasin, että tavalla jolla labyrinttejä generoidaan,syntyy labyrinttejä joissa syvyyshaulla haettu reitti 
on lähes aina samanpituinen kuin leveyshaulla.

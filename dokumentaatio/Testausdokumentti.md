# Testausdokumentti

## Testikattavuus

![TestikattavuusTiralabra](https://user-images.githubusercontent.com/62248076/96376983-cb5d9900-118a-11eb-84c0-703b8dabadea.png)

Testikattavuuden ulkopuolelle on jätetty luokat Freimi, Grafiikat ja Ui.

## Labyrinttien vertailu

![Screenshot from 2020-10-19 17-21-18](https://user-images.githubusercontent.com/62248076/96463743-b71fa780-122f-11eb-8d74-2b0ac3a5195a.png)

Ohjelmassa vertaillaan Primin algoritmillä ja peruuttavalla haulla luotuja 
labyrinttejä keskenään. Labyrintin generoitua, voidaan leveys- tai syvyyshaulla saada 
labyrintin vasemmasta yläkulmasta oikeaan alakulmaan kulkevan reitin pituus.
Generoin 1000000 100x100 labyrinttiä Peruuttavalla haulla, sekä Primin algoritmillä, 
ja vertailin reittien pituuksia keskenään. Peruuttalla haulla generoiduissa labyrinteissä
lyhyin reitti vasemmasta yläkulmasta oikeaan alakulmaan oli aina huomattavasti pidempi kuin Primin
algoritmillä generoiduissa. Peruuttavalla haulla generoidut labyrintin vaativat selvästi enemmän askelia,
kuin primin algoritmillä luodut. Primin algoritmillä luoduissa labyrinteissä pituus oli noin 200-250 askelta,
kun taas peruuttavalla haulla generoiduissa pituus vaihteli 4000 askeleen verran.

Huomasin, että tavalla jolla labyrinttejä generoidaan,syntyy labyrinttejä joissa syvyyshaulla haettu reitti 
oli aina samanpituinen kuin leveyshaulla.

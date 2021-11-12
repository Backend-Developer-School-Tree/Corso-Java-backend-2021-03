# Green Screen :motor_scooter:

In questo esercizio realizzerete un software in grado di utilizzare la tecnica del green screen per aggiungere effetti ad un'immagine.


![infinity war](https://australianimage.com.au/wp-content/uploads/2019/06/green-screen-1.jpg)


## Il green screen

Gli effetti speciali digitali sono sempre più presenti nelle produzioni cinematografiche. Una delle tecniche più utilizzate per poterli inserire è quella di girare le scene con gli attori in un set allestito in maniera tale che ogni elemento che sarà sostituto dal digitale avrà un colore speciale, solitamente un verde acceso. Parallelamente la stessa scena viene ricreata al computer con gli effetti digitali. Una volta che le scene sono pronte, ogni frame del girato reale verrà analizzato e ogni pixel di colore verde verrà sostituito da un pixel creato nella scena digitale.


## L'esercizio

Per questo esercizio vi verranno fornite due immagini, la prima ha un noto youtuber italiano e uno sfondo verde:

![zeb89](./zeb89.jpg)

Mentre la seconda è un'immagine della stessa dimensione della prima:

![aot](./aot.jpg)

Sostituendo ogni pixel verde della prima con il pixel corrispendente della seconda immagine si otterà un'immagine simile a questa:

![output](./outputImage.jpg)

Realizzate quindi un programma che legga le due immagini di input da disco e crei una nuova immagine che somigli il più possibile alla terza.

Per capire quale pixel prendere dalle due immagini, fissate in memoria il colore del pixel da sostituire (il verde acceso) e calcolatevi la distanza da quel pixel e il pixel che state leggendo dalla prima immagine, se questa distanza è più bassa di una certa soglia da voi decisa, allora prenderete il pixel dell'immagine di sfondo. Il concetto di distanza è ben definito per i punti 3D e potete vedere i colori come se fossero dei punti 3D, se non conoscete la formula per scoprire la distanza tra due punti 3D cercatela su internet, sicuramente la troverete!

HINT: I pixel verdi della prima immagini hanno quasi tutti (quelli ai bordi sono diversi) il valore: (48,255,17)
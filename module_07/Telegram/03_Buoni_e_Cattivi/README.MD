# Buoni e Cattivi :kick_scooter:/:motor_scooter:

Realizzare un bot in grado di riconoscere e gestire due tipologie di sticker telegram: quella degli stickers buoni e quella degli stickers cattivi. Per riconoscere le due tipologie non serviranno intelligenze artificiali o cose fantascientifiche, basterà farsi dire dall'utente se lo sticker è buono o cattivo quando ne manda uno nuovo. Perciò il bot quando riceve uno sticker controlla se lo conosce e se fa parte dei buoni o dei cattivi, se non lo conosce chiederà all'utente di farsi dire la tipologia dandolgi una comoda tastiera per farlo.

Il bot inoltre deve anche implementare i seguenti tre comandi:

* __/randomBuoni__: Quando riceve questo comando invia uno sticker buono casuale
* __/randomCattivi__: Quando riceve questo comando invia uno sticker cattivo casuale
* __/random__: Quando riceve questo comando invia uno sticker casuale (buono o cattivo è indifferente)

Il bot dovrà poi salvare su uno o più file (scelgiete voi) i due gruppi di stickers e leggere e caricare gli stickers quando viene avviato.
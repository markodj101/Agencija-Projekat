# Agencija-Projekat

1. Baza podataka koja se koristi u seminarskom radu je agencija i služi za organizaciju i
upravljanje podacima vezanim za aplikaciju. Baza podataka se sastoji od 6 tabela:
Klijent, Admin, Bankovni_racun, Aranzman, Smjestaj i Rezervacija. U tabelama
Klijent i Admin vrijednost kolone korisnicko_ime mora biti jedinstvena. U tabelama
Klijent i Bankovni racun vrijednosti kolona jmbg i broj_racuna moraju biti jednistvene.
2. Potrebno je napisati Java aplikaciju koja ima dvije vrste korisnika: klijent agencije i
admin (agent) u agenciji. Aplikacija služi za rezervacije/uplate jednodnevnih izleta i
aranžmana (u nastavku putovanja).
3. Kada se pokrene aplikacija, korisnicima se prikazuje forma za prijavu u sistem. Da li će
korisnik biti prijavljen kao klijent ili kao admin zavisi od unesenog korisničkog imena.
Takođe, ukoliko korisnik nema nalog u sistemu, nudi mu se mogućnost da kreira novi
nalog. Ukoliko korisnik odluči da kreira novi nalog, od njega se zahtjeva da unese ime,
prezime, broj telefona, jmbg, broj računa u banci, korisničko ime (koje mora biti
slobodno), lozinku i potvrdu lozinke. Potrebno je provjeriti da li je uneseni broj računa
postoji i da li se uneseni jmbg poklapa sa jmbg korisnika u banci. Moguće je kreirati
samo klijentski nalog, nije moguće da neko kreira adminski nalog. Ukoliko prijava nije
potpuna (nisu popunjna sva polja ili račun u banci ne postoji) ili je uneseno korisničko
ime zauzeto, od korisnika se traži da ponovo unese podatke (samo one koji nisu
odgovarajući). Kada klijent kreira novi nalog, automatski se vraća na prethodnu stranu,
odnosno stranu za prijavu.
4. Ukoliko se korisnik prijavi kao klijent, na ekranu mu se prikazuju osnovne infomacije tj.
ime, prezime, korisničko ime. Korisnik može da bira da li da rezerviše novi
izlet/putovanje ili da pogleda listu izleta/putovanja koja je već rezerviso.
5. Korisnik može da pregleda dostupne jednodnevne izlete ili putovanja. Nakon što korisnik
izabere jednu od kategorija, na ekranu mu se prikazuju sve ponude iz te katogorije.
Ponude je moguće soritirati po cijeni ili vremenu do polaska.
Napomena: U bazi podataka, pod jednodevnim izletom se podrazumjeva aranžman kod
koga se datum poslaska i datum dolaska poklapaju, te je vrijednost kolone smještaj
nepoznata (null).
6. Korisnik može da filtirira izlete/putovanja na sljedeći način:
 može da unese opseg cijene izleta/putovanja koju je spreman da plati;
 može da unese dva datuma, a da mu se ispišu svi izleti/putovanja koja su
planirana između dva unesena datuma;
 može da unese destinaciju, te mu se na ekranu ispisuju svi izleti/putovanja na tu
destinaciju;
 može da unese broj zvjezdica smještaja;

 može da unese vrstu sobe (Jednokrevetna, Dvokrevetma, Trokrevetna,

Apartman)

 moze da unese način prevoza (Avion, Autobus ili Samostalan)
Napomena: Moguće je kombinovati i više filtera odjednom.
Korisnik može da se vrati na početnu stanu ili da odabere neki od ponuđenih
izleta/putovanja. Ukoliko korisnik izabere neki od izleta/putovanja, od njega se traži da
potvrdi rezervaciju tako sto će ponovo da unese svoju lozinku. Da bi potvrda bila
uspješna korisniku se sa računa skida 50% od ukupne cijene izleta/putovanja i taj iznos se
dodaje na račun agencije. Ukoliko korisnik nema dovoljno novca na računu, rezervacija
neće biti uspješna, te se koriniku ispisuje odgovarajuća poruka. Nakon potvrde
rezervacije, korisnik se vraća na pocetnu stranu, a u listu rezervisanih izleta/putovanja mu
se dodaje upravo potvrđena rezervacija.
7. Kada korisnik otvori listu rezervacija, pored rezervacija na ekranu mu se ispisuju
informacije o ukupnoj količini novca koju je korisnik do sada potrošio na
izlete/putovanja, kao i koliko još novca treba da doplati za izlete/putovanja koja nije u
potpunosi platio. Rezervacije treba da budu podjeljene u tri katogorije:
 Aktivne rezervacije
 Protekle rezervacije
 Otkazane rezervacije
Kada korisnik odabere neku od rezervacija nude mu se sljedeće opcije:
 Korisnik može da uplati ostatak izleta/putovanja najkasnije 2 sedmice pred
polazak. Ukoliko korisnik ne uplati ostatak izleta na vrijeme, rezervacija mu se
ukida, a agencija uzima 50% ukupne cijene izleta, dok se ostatak (sve iznad 50%
cijene) vraća korisniku (u ovom slučaju, rezervacija se premješta u otkazane
rezervacije). Korinsik ne mora odjednom da uplati ostatak izleta/putovanja, nego
to može uraditi u nekoliko navrata. Prilikom svake nove uplate od korisnika se
traži da potvrdi uplatu tako što će da unese svoju lozinku i svaki put se provjerava
da li korisnik ima dovoljno sredstava na računu. Ukoliko je korisniku ostalo tri
dana ili manje da doplati ostatak nekog izleta/putovanja, prilikom svakog
prijavljivanja u sistem korisniku se ispisuje informacija o tome. Takođe, kada
korisnik otvori listu aktivnih rezervacija, te rezervacije treba da budu posebno
označene.
 Korisnik može da otkaže rezervaciju najkasnije 2 sedmice prije polaska. Ukoliko
korisnik na vrijeme otkaže rezervaciju, sav novac će mu biti vraćen, a rezervacija
se premješta u otkazane rezervacije.
Napomena: Nakon svake transakcije, korisniku se šalje poruka o trenutnom stanju na
njegovom računu.
8. Ukoliko se korisnik u sistem prijavi kao admin, prikazuju mu se osnovne informacije o
njemu (ime, prezime, korisničko ime). Takođe, prikazuje mu se i informacija o ukupnom
broju admina agencije.
9. Admin može da doda novog admina u sistem. Ukoliko admin odabere opciju da unese
novog admina, od njega se traži da unese njegovo ime, prezime i korisničko ime.
Njegova loznika će biti postavljena na podrazumijevanu lozinku (12345678). Kada se tek

dodani admin prvi put prijavi u sistem, od njega se traži da unese svoju novu lozinku.
Nakon dodavanja novog admina potrebno je ažurirati broj admina u agenciji.
10. Admin ima opciju da pogleda listu svih rezervacija u agenciji. Kada admin otvori spisak
svih rezervacija, na ekranu mu se pored rezervacija ispisuje informacija o tome koliko
novca je agencija do sada zaradila, i koliko još novca klijenti moraju da doplate za svoje
rezervacije. Klikom na neku od rezervacija adminu se prikazuje lista klijenata koji su
rezervisali taj izlet/putovanje, kao i infomacija koliko je taj klijent do sada uplatio novca i
koliko novca još mora da uplati. Ukoliko je za uplatu neke rezervacije ostalo još tri dana
ili manje, ta rezervacija treba da bude posebno označena, a pored rezervacije treba da
stoji i broj telefona klijenta, kako bi admin mogao što lakše da ga kontaktira.
11. Admin može da doda novi izlet/putovanje tako što ce popuniti sva potrebna polja:
 Za izlet:
o Naziv izleta, destinacija, datum polaska, cijena izleta
 Za putovanje:
o Naziv putovanja, destinacija, tip prevoza, datum polaska, datum povratka,
cijena aranžmana, naziv smještaja, broj zvjezdica smještaja, vrsta sobe,
cijena po noćenju

12. Admin takođe može i da otkaže izlet/putovanje. Ukoliko admin otkaže izlet/putovanje,
onda se sve rezervacije za izlet/putovanje brišu, svim korisnicima koji su rezervisali izlet/
putovanje se vraća novac, a izlet/putovanje se uklanja sa liste izleta/putovanja. Na kraju,
na ekranu se ispisuje informacija o tome koliko novca je agencija izgubila otkazivanjem
izleta/putovanja. Ukoliko se neko putovanje otkaže, ono se takodje briše iz liste
rezervacija klijenata agencije (ne prikazuje se ni u jednoj kategoriji rezervacija). Nakon
što se putovanje otkaže, svi klijenti koji su to putovanje rezervisali pri prvom sljedećem
prijavljivanju dobijaju informaciju o otkazivanju izleta/putovanja i o stanju na njihovom
računu nakon što je izlet otkazan.
13. Svi prijavljeni korisnici imaju mogućnost da promjene svoje lozinke.
14. Obezbjediti navigaciju naprijed-nazad po kompletnoj aplikaciji.
15. U tabeli Bankovni racun vrijednost kolone jmbg za broj računa agencije se sastoji od 10
cifara, dok se vrijednost kolone jmbg za sve ostale korisnike sastoji od 13 cifara.
16. Na dan polaska izlet/putovanje se uklanja iz liste ponuda izleta/putovanja. Klijentima se
taj izlet/putovanje prebacuje u kategoriju proteklih rezervacija. U ovom slučaju
klijentima nije potrebno vratiti novac.
17. Ukupna cijana putovanja se računa na sljedeći način:
cijena aranžmana + broj noći ∙ cijena po noćenju.

Uputstva:
1. Za svaku tabelu iz baze podataka kreirati klasu
2. Učitati podatke iz baze podataka i smjestiti ih u odgovarajuće kolekcije podataka
3. SQL upite koristiti samo prilikom dodavanja novih podataka, brisanja ili ažuriranja
podataka

4. Ako SQL tabela ima kolonu koja sadrži ID podatka iz druge tebele (zbog jednostavnosti
označimo te tabele sa A i B), onda je potrebno da objekat klase koja odgovara tebeli A
kao atribut sadrži odgovarajući objekat klase koja odgovara tebeli B
Na primjer, tabela Aranzman sadrži smjestaj_id, što znači da klasa Aranzman ima
atribut tipa Smjestaj

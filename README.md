# Agencija-Projekat

## Baza Podataka
Baza podataka koja se koristi u seminarskom radu je agencija i služi za organizaciju i upravljanje podacima vezanim za aplikaciju. Baza podataka se sastoji od 6 tabela: 
- **Klijent**
- **Admin**
- **Bankovni_racun**
- **Aranzman**
- **Smjestaj**
- **Rezervacija**

U tabelama **Klijent** i **Admin** vrijednost kolone `korisnicko_ime` mora biti jedinstvena. U tabelama **Klijent** i **Bankovni_racun** vrijednosti kolona `jmbg` i `broj_racuna` moraju biti jedinstvene.

## Aplikacija
Potrebno je napisati Java aplikaciju koja ima dvije vrste korisnika:
- Klijent agencije
- Admin (agent) u agenciji

Aplikacija služi za rezervacije/uplate jednodnevnih izleta i aranžmana (u nastavku putovanja).

## Funkcionalnosti

### 1. Prijava i Registracija
- Kada se pokrene aplikacija, korisnicima se prikazuje forma za prijavu u sistem.
- Prijava kao klijent ili admin zavisi od unesenog korisničkog imena.
- Ukoliko korisnik nema nalog u sistemu, može kreirati novi nalog unoseći potrebne podatke.
- Moguće je kreirati samo klijentski nalog.

### 2. Funkcionalnosti Klijenta
- Pregled osnovnih informacija (ime, prezime, korisničko ime).
- Mogućnost rezervacije novog izleta/putovanja ili pregled liste rezervisanih izleta/putovanja.
- Pregled dostupnih jednodnevnih izleta ili putovanja sa mogućnošću sortiranja po cijeni ili vremenu do polaska.
- Filtriranje izleta/putovanja po cijeni, datumu, destinaciji, broju zvjezdica smještaja, vrsti sobe i načinu prevoza.
- Potvrda rezervacije unosom lozinke i skidanje 50% ukupne cijene sa računa.
- Pregled liste rezervacija i informacije o ukupnoj potrošnji.

### 3. Funkcionalnosti Admina
- Pregled osnovnih informacija i ukupnog broja admina.
- Dodavanje novog admina sa podrazumijevanom lozinkom (12345678).
- Pregled liste svih rezervacija sa informacijom o zaradi agencije.
- Dodavanje novog izleta/putovanja unosom potrebnih podataka.
- Otkazivanje izleta/putovanja i povrat novca korisnicima.

### 4. Dodatne Funkcionalnosti
- Promjena lozinke za sve prijavljene korisnike.
- Navigacija naprijed-nazad po kompletnoj aplikaciji.
- Uklanjanje izleta/putovanja iz ponude na dan polaska i prebacivanje u protekle rezervacije.

## Uputstva

### 1. Kreiranje Klasa
- Za svaku tabelu iz baze podataka kreirati klasu.

### 2. Učitavanje Podataka
- Učitati podatke iz baze podataka i smjestiti ih u odgovarajuće kolekcije podataka.

### 3. Korištenje SQL Upita
- SQL upite koristiti samo prilikom dodavanja novih podataka, brisanja ili ažuriranja podataka.

### 4. Relacije između Tabela
- Ako SQL tabela ima kolonu koja sadrži ID podatka iz druge tabele (npr. tabela Aranzman sadrži `smjestaj_id`), klasa Aranzman treba da ima atribut tipa Smjestaj.

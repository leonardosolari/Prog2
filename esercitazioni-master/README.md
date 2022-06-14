# Prog2@UniMI Esercitazioni

[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](http://www.gnu.org/licenses/gpl-3.0)
[![License: CC BY-SA 4.0](https://img.shields.io/badge/License-CC%20BY--SA%204.0-blue.svg)](http://creativecommons.org/licenses/by-sa/4.0/)
[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://bit.ly/34lXYkT)

Questo repository contiene il materiale di supporto alle *esercitazioni*
dell'insegnamento di [Programmazione II](https://prog2.di.unimi.it/) del corso
di laurea in [Informatica](https://informatica.cdl.unimi.it/it) dell'[Università
degli Studi di Milano](http://www.unimi.it/).

## Istruzioni d'uso

Per svolgere le esercitazioni è sufficiente premere il bottone sottostante

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://bit.ly/34lXYkT)

utile ad accedere ad un *workspace* di [Gitpod](https://www.gitpod.io/) che
consiste di una istanza dell'editor [Visual Studio
Code](https://code.visualstudio.com/) e
dell'[OpenJDK](https://openjdk.java.net/) offerti gratuitamente come servizio
cloud e già configurati per lo svolgimento delle esercitazioni.

### Il workspace

Il *workspace* creato è persistente e personalizzato, potete trovare maggiori
informazioni nella [documentazione di Gitpod](https://www.gitpod.io/docs/); una
volta attivato il *workspace* lo studente può (iniziare a) svolgere una
esercitazione aprendo un terminale nel *workspace* e impartendo il comando

    svolgi <NOME_ESERCITAZIONE>/<MATRICOLA>

dove `<NOME_ESERCITAZIONE>` è il nome dell'esercitazione che verrà comunicato
dal docente e `<MATRICOLA>` è il numero di matricola dello studente.

**Attenzione**: *non è possibile usare due workspace diversi per la medesima
esercitazione*, per cui per proseguire una esercitazione interrotta controllate
prima nell'[elenco dei suoi workspace](https://gitpod.io/workspaces/) e, nel
caso, riavviate il relativo *workspace* esistente.

## Il cruscotto

Le esercitazioni vengono sottoposte a *continuous testing* (basato su [Scythe
Suite](https://github.com/scythe-suite)); ciascuno studente può tenere traccia
in tempo reale dei suoi risultati sull'[apposito
cruscotto](http://reaper.srv.di.unimi.it/st/prog2ese/).

## Sul proprio computer

I **più esperti** possono svolgere le esercitazioni anche usando il proprio
computer, a tal fine è necessario che esso sia configurato in modo tale che
siano correttamente installati e configurati i seguenti software:

* bash (versione 5, o superiore),
* git (versione 2.28, o superiore),
* Python (versione 3.8, o superiore),
* Java Development Kit (versione 11, o superiore).

Una volta accertato questo prerequisito, è sufficiente (al primo utilizzo):

*  *clonare* questo repository,
* aggiungere il percorso assoluto della directory `.bin` in esso contenuta al *path*,
* definire la variabile d'ambiente `PROG2HOME` in modo che contenga il percorso
  assoluto della directory dove si intendono svolgere gli esercizi;

a questo punto è possibile procedere nel modo descritto per l'uso su Gitpod.

Questa modalità è riservata agli studenti già esperti nell'uso degli strumenti
indicati, ragione per la quale non è previsto alcun supporto ulteriore in caso
di problemi, o malfunzionamenti.

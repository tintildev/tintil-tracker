# Tintil Tracker 🎯

Ein universeller, webbasierter Projekt- und Task-Tracker zur Verwaltung von Software-Projekten, Lernzielen, Renovierungsarbeiten und alltäglichen Vorhaben.

## 💡 Idee & Zielsetzung

Ziel von **Tintil Tracker** ist es, eine flexible Plattform zu schaffen, auf der Projekte unterschiedlichster Natur (Dev-Projekte, Heimwerken, Lernen) strukturiert in Phasen und Aufgaben unterteilt und visuell nachverfolgt werden können.

Das Projekt wird im Rahmen eines fokussierten 6-Wochen-Entwicklungszyklus als Full-Stack-Anwendung aufgebaut. 
Das wichtigste für mich ist zu lernen, neue Technologien kennen zu lernen und nicht nur stumpf KI Vorschlägen zu folgen.

---

## 🛠 Geplanter Tech Stack

### Backend
- **Java 21+**
- **Spring Boot 3.x** (REST API)
- **Spring Data JPA**
- **H2** (Entwicklung) / **PostgreSQL** (Produktion)
- **Maven**

### Frontend
- **React** (mit Vite)
- **Tailwind CSS** (Utility-First Styling)


## Architektur & Projektstrutkru
Ich entscheide in diesen Projekt für ein Backend mit **Schichten-Architektur (Layered Architecture)** zur strikten Trennung von Zuständigkeiten (*Separation of Concerns*). Weg von MVC Architektur hin zu einem modernen Standard. 

```text
com.tintil.tintiltracker
├── controller   # REST-Endpunkte & HTTP-Routing (JSON I/O)
├── service      # Geschäftslogik & Validierungen
├── repository   # Datenbanzugriff via Spring Data JPA
└── model        # Datenbank-Entities (Domain Model)
```

### Schichtenmodell:
1. **Controller Layer (`@RestController`):** Nimmt HTTP-Anfragen entgegen, steuert Statuscodes und delegiert an die Service-Schicht.
2. **Service Layer (`@Service`):** Kapselt die reine Geschäftslogik. Unabhängig von HTTP und Datenbankspezifika.
3. **Repository Layer (`@Repository`):** Abstrahiert Datenbankabfragen über JPA/Hibernate.
4. **Model Layer (`@Entity`):** Definiert das objektrelationale Mapping (ORM) für die Datenbanktabellen.
---

## 🚀 Roadmap

- [x] Repository-Setup, Lizenz & Dokumentation (Initial)
- [x] Backend API Fundament (Spring Boot Initialisierung)
- [ ] Datenmodellierung (Entities: `Project`, `Task`)
- [ ] REST Controller & CRUD Endpunkte
- [ ] Integrationstest der API
- [ ] Frontend-Setup (React + Vite + Tailwind CSS)
- [ ] Deployment & Docker-Containerisierung (Dockerfile & docker-compose)
- [ ] Dashboard & Kanban-/Task-Ansichten
- [ ] Ausführliche Anwendungs-Dokumentation & Setup-Guide

---

## 📑 Geplante API-Schnittstellen (Übersicht)

| Methode | Endpunkt | Beschreibung |
| :--- | :--- | :--- |
| `GET` | `/api/projects` | Alle Projekte abrufen |
| `POST` | `/api/projects` | Neues Projekt anlegen |
| `GET` | `/api/projects/{id}` | Projektdetails & zugehörige Tasks abrufen |
| `POST` | `/api/projects/{id}/tasks` | Neue Aufgabe zu einem Projekt hinzufügen |
| `PATCH` | `/api/tasks/{id}` | Task-Status aktualisieren (`TODO`, `IN_PROGRESS`, `DONE`) |

---

## 📜 Lizenz

Dieses Projekt ist unter der [MIT License](LICENSE) lizenziert.
# Tintil Tracker 🎯

Ein universeller, webbasierter Projekt- und Task-Tracker zur Verwaltung von Software-Projekten, Lernzielen, Renovierungsarbeiten und alltäglichen Vorhaben.

## 💡 Idee & Zielsetzung

Ziel von **Tintil Tracker** ist es, eine flexible Plattform zu schaffen, auf der Projekte unterschiedlichster Natur (Dev-Projekte, Heimwerken, Lernen) strukturiert in Phasen und Aufgaben unterteilt und visuell nachverfolgt werden können.

Das Projekt wird im Rahmen eines fokussierten 6-Wochen-Entwicklungszyklus als Full-Stack-Anwendung neu aufgebaut.

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
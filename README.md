# Tintil Tracker 🎯

Readme in: [English](README.md) | [Deutsch](README.de.md)

A universal, web-based project and task tracker designed to manage software development projects, learning goals, home renovations, and everyday endeavors.

## 💡 Concept & Goals

The goal of **Tintil Tracker** is to provide a flexible platform where various types of projects (software development, DIY/renovation, personal learning) can be structured into phases and tasks for visual progress tracking.

This project is being built as a full-stack application within a focused 6-week development cycle.  
The core objective for me is **hands-on learning**: deeply understanding new technologies and architectures rather than blindly following AI-generated code snippets.

---

## 🛠 Planned Tech Stack

### Backend
- **Java 21+**
- **Spring Boot 3.x / 4.x** (REST API)
- **Spring Data JPA**
- **H2 Database** (Development) / **PostgreSQL** (Production)
- **Maven**

### Frontend
- **React** (powered by Vite)
- **Tailwind CSS** (Utility-First Styling)

---

## 🏗 Architecture & Project Structure

This project adopts a layered backend architecture (**Layered Architecture**) to enforce strict **Separation of Concerns**, moving away from classic server-side MVC toward modern API standards.

```text
com.tintil.tintiltracker
├── controller   # REST endpoints & HTTP routing (JSON I/O)
├── service      # Business logic & domain validations
├── repository   # Data access layer via Spring Data JPA
└── model        # Database entities & domain models

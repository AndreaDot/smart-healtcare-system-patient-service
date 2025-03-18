# **Smart Healthcare System - Documentazione Tecnica**

## **1. Introduzione**
Il progetto **Smart Healthcare System** è un sistema di gestione delle prenotazioni mediche che permette ai pazienti di prenotare visite, ai medici di gestire il proprio calendario e alle farmacie di ricevere prescrizioni elettroniche. Il sistema è basato su un'architettura **a microservizi**, utilizzando comunicazione **sincrona (REST API)** e **asincrona (Kafka/ActiveMQ)**, con database relazionali per la persistenza dei dati.

---

## **2. Architettura del Sistema**
### **2.1 Microservizi Coinvolti**

1. **Patient Service**: Gestisce la registrazione e i dati dei pazienti.
2. **Doctor Service**: Gestisce le informazioni dei medici e il loro calendario.
3. **Appointment Service**: Permette ai pazienti di prenotare visite con i medici.
4. **Billing Service**: Gestisce il pagamento delle visite mediche.
5. **Pharmacy Service**: Riceve prescrizioni elettroniche.
6. **Notification Service**: Invia notifiche (email/SMS) ai pazienti e ai medici.

### **2.2 Diagramma dell'Architettura**
(Inserire un diagramma UML con relazioni tra i microservizi)

---

## **3. Comunicazione tra Microservizi**

### **3.1 Comunicazione Sincrona (REST API con OpenFeign)**
- `Appointment Service` chiama `Doctor Service` per verificare la disponibilità del medico.
- `Appointment Service` chiama `Billing Service` per elaborare il pagamento.

### **3.2 Comunicazione Asincrona (Kafka/ActiveMQ)**
- Dopo la conferma della visita, `Appointment Service` pubblica un evento su **Kafka/ActiveMQ** per notificare il paziente e il medico.
- Dopo una visita, `Doctor Service` genera una prescrizione e pubblica un evento su **Kafka/ActiveMQ**; `Pharmacy Service` lo consuma e aggiorna il database delle prescrizioni.

---

## **4. Database e Modelli Dati**
### **4.1 Database Relazionali (PostgreSQL)**
Ogni microservizio ha il proprio database separato:
- **Patient Service**: `patients (id, nome, cognome, email, telefono)`
- **Doctor Service**: `doctors (id, nome, specializzazione, calendario)`
- **Appointment Service**: `appointments (id, patient_id, doctor_id, data, stato)`
- **Billing Service**: `invoices (id, appointment_id, importo, stato_pagamento)`
- **Pharmacy Service**: `prescriptions (id, patient_id, doctor_id, farmaco, dose)`

### **4.2 Database NoSQL (MongoDB/Redis per Notifiche)**
- `notifications (id, user_id, tipo, messaggio, stato)`

---

## **5. Stack Tecnologico**

- **Backend**: Spring Boot, Spring Cloud, Spring Data JPA
- **Database**: PostgreSQL (per dati relazionali), MongoDB/Redis (per notifiche)
- **Comunicazione Sincrona**: Spring Cloud OpenFeign, RestTemplate
- **Comunicazione Asincrona**: Apache Kafka o ActiveMQ
- **Sicurezza**: Spring Security + JWT
- **Service Discovery**: Eureka Server
- **Orchestrazione**: Docker, Kubernetes (opzionale)

---

## **6. Implementazione Step-by-Step**

### **6.1 Configurazione del Progetto**
- Creare un progetto Maven/Gradle per ogni microservizio.
- Configurare Spring Boot con dipendenze necessarie.
- Configurare database PostgreSQL con Spring Data JPA.

### **6.2 Implementazione dei Microservizi**
1. **Patient Service**
   - Creare entità `Patient`
   - Implementare repository e service per la gestione pazienti
   - Creare API REST per registrazione/login con Spring Security + JWT
   - Connettere il servizio a PostgreSQL

2. **Doctor Service**
   - Creare entità `Doctor`, `Schedule`
   - Implementare repository e API REST per la gestione dei medici

3. **Appointment Service**
   - Creare entità `Appointment`
   - Implementare repository e API REST per la gestione delle prenotazioni
   - Integrare OpenFeign per comunicazione con `Doctor Service`

4. **Billing Service**
   - Creare entità `Invoice`
   - Implementare pagamento con API REST

5. **Pharmacy Service**
   - Creare entità `Prescription`
   - Implementare gestione delle prescrizioni

6. **Notification Service**
   - Configurare Kafka/ActiveMQ
   - Creare consumer per gestire notifiche

### **6.3 Service Discovery e Load Balancing**
- Configurare Eureka Server per la registrazione dei microservizi.
- Configurare Resilience4J per circuit breaker nelle chiamate REST.

### **6.4 Sicurezza e Autenticazione**
- Implementare Spring Security + JWT per protezione API.
- Creare filtri per gestione autorizzazioni.

### **6.5 Deployment e Containerizzazione**
- Creare Dockerfile per ogni microservizio.
- Configurare Docker Compose per orchestrare i servizi.
- (Opzionale) Configurare Kubernetes per il deployment in cloud.

---

## **7. API Endpoints**

### **7.1 Patient Service**
- `POST /patients/register` - Registrazione utente
- `POST /patients/login` - Login
- `GET /patients/{id}` - Ottenere dati del paziente

### **7.2 Doctor Service**
- `GET /doctors/{id}` - Ottenere dati del medico
- `GET /doctors/{id}/schedule` - Ottenere disponibilità medica

### **7.3 Appointment Service**
- `POST /appointments` - Prenotare una visita
- `GET /appointments/{id}` - Ottenere dettagli prenotazione

### **7.4 Billing Service**
- `POST /payments` - Effettuare un pagamento
- `GET /payments/{id}` - Verificare stato pagamento

### **7.5 Pharmacy Service**
- `GET /prescriptions/{id}` - Ottenere prescrizione

---

## **8. Conclusione**

Questa documentazione fornisce una guida chiara e dettagliata per implementare **Smart Healthcare System**. Il progetto utilizza le migliori pratiche per architettura a microservizi e include comunicazione sincrona e asincrona, gestione sicura dei dati e scalabilità con Docker/Kubernetes.

Se hai bisogno di approfondimenti o di codice di esempio, fammi sapere! 🚀


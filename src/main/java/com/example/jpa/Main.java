package com.example.jpa;

import com.example.jpa.entities.Salle;
import com.example.jpa.entities.Utilisateur;
import com.example.jpa.service.ServiceGestion;

public class Main {

    public static void main(String[] args) {
        ServiceGestion service = new ServiceGestion();
        try {
            Salle salle = new Salle("Salle A", 10);
            service.ajouterSalle(salle);
            service.ajouterUtilisateur(new Utilisateur("Alice", "alice@demo.com", salle));
            service.ajouterUtilisateur(new Utilisateur("Bob", "bob@demo.com", salle));

            System.out.println("=== Salles ===");
            service.listerSalles().forEach(System.out::println);

            System.out.println("=== Utilisateurs de Salle A ===");
            service.utilisateursParSalle("Salle A").forEach(System.out::println);
        } finally {
            service.fermer();
        }
    }
}

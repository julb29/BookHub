import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

// Interface pour typer proprement le membre
interface UserProfile {
  lastname: string;
  firstname: string;
  phone: string;
  email: string;
}

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './profile.html',
  styleUrl: './profile.css',
})
export class Profile implements OnInit {
  // Données de l'utilisateur liées au formulaire
  user: UserProfile = {
    lastname: '',
    firstname: '',
    phone: '',
    email: '',
  };

  // Champs du formulaire de changement de mot de passe
  passwords = {
    current: '',
    new: '',
  };

  constructor(private router: Router) {}

  ngOnInit(): void {
    // 1. Récupération des données depuis le localStorage
    const savedUser = localStorage.getItem('currentUser');
    const savedEmail = localStorage.getItem('userEmail'); // Récupéré lors de ton login

    if (savedUser) {
      // Si un profil complet est déjà enregistré
      this.user = JSON.parse(savedUser);
    } else {
      // Sinon, on initialise un profil par défaut avec l'email du login
      this.user = {
        lastname: 'Dupont',
        firstname: 'Jean',
        phone: '06 12 34 56 78',
        email: savedEmail || 'jean.dupont@example.com',
      };
      // On sauvegarde ce profil initial dans le localStorage
      localStorage.setItem('currentUser', JSON.stringify(this.user));
    }
  }

  // 1. Modification des informations (Nom, Prénom, Téléphone)
  onUpdateInfo(): void {
    // Sauvegarde de l'objet utilisateur mis à jour dans le localStorage
    localStorage.setItem('currentUser', JSON.stringify(this.user));
    alert('Vos informations personnelles ont été mises à jour !');
  }

  // 2. Modification du mot de passe
  onChangePassword(): void {
    if (!this.passwords.current || !this.passwords.new) {
      alert('Veuillez remplir les deux champs de mot de passe.');
      return;
    }

    // Simulation de la sauvegarde du mot de passe
    localStorage.setItem('userPassword', this.passwords.new);
    alert('Votre mot de passe a été modifié avec succès !');

    // Réinitialisation des champs du formulaire
    this.passwords.current = '';
    this.passwords.new = '';
  }

  // 3. Suppression du compte (RGPD)
  onDeleteAccount(): void {
    const confirmed = confirm(
      'Êtes-vous sûr de vouloir supprimer définitivement votre compte ? Cette action est irréversible.',
    );

    if (confirmed) {
      // Nettoyage complet du localStorage
      localStorage.removeItem('currentUser');
      localStorage.removeItem('userEmail');
      localStorage.removeItem('userPassword');

      alert('Votre compte a été supprimé.');

      // Redirection vers la page de login
      this.router.navigate(['/login']);
    }
  }
}

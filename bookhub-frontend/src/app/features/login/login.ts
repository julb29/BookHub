import { Component } from '@angular/core';
import { AuthService } from '../../core/services/auth-service';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  public email: string = '';
  public password: string = '';
  public errorMessage: string = '';

  constructor(
    public authService: AuthService,
    private router: Router,
  ) {}

  public login(): void {
    if (!this.email || !this.password) {
      //console.log(' Bouton cliqué !', this.email, this.password);
      this.errorMessage = 'Veuillez remplir tous les champs.';
      return;
    }

    // Réinitialisation du message d'erreur
    this.errorMessage = '';

    //Abonnement à l'observable renvoyé par le service
    this.authService.login(this.email, this.password).subscribe({
      next: (response) => {
        // Le serveur a validé les identifiants
        // On enregistre le token et/ou les infos reçues du bac
        if (response.token) {
          localStorage.setItem('token', response.token);
        }
        // Exemple d'enregistrement des infos utilisateur
        localStorage.setItem('userEmail', this.email);

        // Redirection vers /home une fois connecté
        this.router.navigate(['/home']);
      },
      error: (error) => {
        // Échec ! Mauvais mot de passe, utilisateur inconnu, etc.
        console.error('Erreur de connexion :', error);

        if (error.status === 401) {
          this.errorMessage = 'Email ou mot de passe incorrect.';
        } else {
          this.errorMessage = 'Une erreur est survenue lors de la connexion.';
        }
      },
    });
  }


}

import { ChangeDetectorRef, Component } from '@angular/core';
import { AuthService } from '../../core/services/auth-service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
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

    // Appels des deux arguments vers le service
    this.authService.login(this.email, this.password);

    // PROVISOIRE !!! Sauvegarder l'email dans le navigateur pour le Header
    localStorage.setItem('userEmail', this.email);

    // Redirection après enregistrement
    this.router.navigate(['/home']);

  }
}

import { Component } from '@angular/core';
import { AuthService } from '../../services/auth-service';
import { Router } from '@angular/router';
import { Nav } from './nav/nav';

@Component({
  selector: 'app-header',
  imports: [Nav],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  public email: string = '';

  constructor(
    private authService: AuthService,
    private router: Router,
  ) {}

  // PROVISOOIRE !!! s'exécute automatiquement au chargement du composant
  public ngOnInit(): void {
    this.email = localStorage.getItem('userEmail') || '';
  }

  public logout(): void {
    // PROVISOIRE !!! Supprimer l'email au moment de la déconnexion
    localStorage.removeItem('userEmail');

    // 1. Logique de déconnexion (ex: effacer le token)
    this.authService.logout();

    // 2. Redirection vers la page de login
    this.router.navigate(['/login']);
  }
}

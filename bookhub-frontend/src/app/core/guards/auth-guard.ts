import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const userEmail = localStorage.getItem('userEmail');

  // Si l'utilisateur a un email enregistré (il est connecté)
  if (userEmail) {
    return true;
  }

  // Sinon, on le redirige vers le login
  router.navigate(['/login']);
  return false;
};

import { Routes } from '@angular/router';
import { Login } from './features/login/login';
import { Register } from './features/register/register';
import { Home } from './features/home/home';
import { MainLayout } from './shared/components/main-layout/main-layout';
import { authGuard } from './core/guards/auth-guard';
import { Profile } from './features/profile/profile';

export const routes: Routes = [
  // 1. Pages publiques (SANS Header ni Footer)
  { path: 'login', component: Login },
  { path: 'register', component: Register },

  // 2. Pages protégées (AVEC Header et Footer)
  {
    path: '',
    component: MainLayout,
    canActivate: [authGuard],
    children: [
      { path: 'home', component: Home },
      { path: 'profile', component: Profile },
      { path: '', redirectTo: 'home', pathMatch: 'full' },
    ],
  },

  // 3. Redirection si l'URL n'existe pas -> va vers le login
  { path: '**', redirectTo: 'login' },
];

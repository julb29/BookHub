import { Routes } from '@angular/router';
import { Login } from './features/login/login';
import { Home } from './features/home/home';
import { MainLayout } from './shared/components/main-layout/main-layout';
import { authGuard } from './core/guards/auth-guard';

export const routes: Routes = [
  // 1. Page de Login (seule, sans Header/Footer)
  { path: 'login', component: Login },

  // 2. Pages avec le Layout (avec Header/Footer)
  {
    path: '',
    component: MainLayout,
    canActivate: [authGuard],
    children: [
      { path: 'home', component: Home },
      //{ path: 'profile', component: Profile },
      { path: '', redirectTo: 'home', pathMatch: 'full' },
    ],
  },

  // Redirection par défaut
  { path: '**', redirectTo: 'login' },
];

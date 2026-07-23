import { Routes } from '@angular/router';
import { Login } from './features/login/login';
import { MainLayout } from './shared/components/main-layout/main-layout';
import { Home } from './features/home/home';

export const routes: Routes = [
  // Route par défaut (redirige la racine vers /login ou /home)
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  // La route pour la page de connexion
  { path: 'login', component: Login },

  //  La route vers laquelle tu rediriges après la connexion
  { path: 'home', component: Home },

  // Route "catch-all" en cas d'URL inconnue (optionnel)
  { path: '**', redirectTo: 'login' },
];

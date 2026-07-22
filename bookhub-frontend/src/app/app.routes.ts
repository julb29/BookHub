import { Routes } from '@angular/router';
import { Login } from './features/login/login';
import { MainLayout } from './shared/components/main-layout/main-layout';
import { Home } from './features/home/home';

export const routes: Routes = [
  {path: "login", component: Login},
  {
    path: "", component: MainLayout, children: [
      {path: "", redirectTo: "home", pathMatch: "full"},
      {path: "home", component: Home},

    ]
  }

];

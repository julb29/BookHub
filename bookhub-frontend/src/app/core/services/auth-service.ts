import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  // La méthode accepte maintenant email et password
  public login(email: string, password: string): void {
    const user = {
      email: email,
    };
    localStorage.setItem('user', JSON.stringify(user));
  }

  public logout(): void {
    localStorage.removeItem('user');
  }

  public isLogged(): boolean {
    const user = localStorage.getItem('user');
    return !!user;
  }

  public getUsername(): string {
    if (this.isLogged()) {
      const user = JSON.parse(localStorage.getItem('user')!);
      return user.email;
    }
    return '';
  }
}

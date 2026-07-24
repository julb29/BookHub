import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private http = inject(HttpClient);
  private url = 'http://localhost:8080/api';

  // La méthode renvoie une Observable
  public login(email: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.url}/login`, { email, password });
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

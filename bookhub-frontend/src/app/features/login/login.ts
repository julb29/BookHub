import { Component } from '@angular/core';
import { AuthService } from '../../core/services/auth-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  public email: string;
  public password: string;

  constructor(
    public authService: AuthService,
    private router: Router,
  ) {
    this.email = '';
    this.password = '';
  }

  public login() {

  }

}

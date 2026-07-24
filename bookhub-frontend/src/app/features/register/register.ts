import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router'; // 1. Import du Router
import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {
  private fb = inject(FormBuilder);
  private router = inject(Router); // 2. Injection du Router

  // Validateur personnalisé propre pour le mot de passe
  private passwordMatchValidator = (control: AbstractControl): ValidationErrors | null => {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;

    const confirmControl = control.get('confirmPassword');

    if (password && confirmPassword && password !== confirmPassword) {
      // Si mismatch, on applique l'erreur au champ confirmPassword
      confirmControl?.setErrors({ ...confirmControl.errors, passwordMismatch: true });
      return { passwordMismatch: true };
    } else if (confirmControl?.hasError('passwordMismatch')) {
      // Si les mots de passe correspondent à nouveau, on nettoie l'erreur spécifique
      const { passwordMismatch, ...remainingErrors } = confirmControl.errors || {};
      confirmControl.setErrors(Object.keys(remainingErrors).length ? remainingErrors : null);
    }

    return null;
  };

  registerForm: FormGroup = this.fb.group(
    {
      firstName: ['', [Validators.required, Validators.minLength(2)]],
      lastName: ['', [Validators.required, Validators.minLength(2)]],
      phone: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      confirmPassword: ['', [Validators.required]],
    },
    { validators: this.passwordMatchValidator },
  );

  onSubmit(): void {
    if (this.registerForm.valid) {
      console.log("Données d'inscription :", this.registerForm.value);

      // TODO: Appeler ton service d'inscription ici
      // ex: this.authService.register(this.registerForm.value);

      // 3. Redirection de l'utilisateur après inscription !
      this.router.navigate(['/home']);
    } else {
      // Marque tous les champs pour afficher les erreurs en rouge si le formulaire est incomplet
      this.registerForm.markAllAsTouched();
    }
  }
}

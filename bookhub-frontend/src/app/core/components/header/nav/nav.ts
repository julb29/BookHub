import { Component, input, output } from '@angular/core';
import { RouterLink, RouterModule } from '@angular/router';

@Component({
  selector: 'app-nav',
  imports: [RouterLink],
  templateUrl: './nav.html',
  styleUrl: './nav.css',
})
export class Nav {
    email = input.required<string>();
    logoutEvent = output<void>() ;// new EventEmitter<void>()

  public logout() {
      this.logoutEvent.emit();

  }
}

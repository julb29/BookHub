import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-nav',
  imports: [],
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

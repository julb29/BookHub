import { Component } from '@angular/core';
import { App } from '../../../app';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-footer',
  imports: [DatePipe],
  templateUrl: './footer.html',
  styleUrl: './footer.css',
})
export class Footer {

  public today : Date = new Date();

}

import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Armarios', url: '/folder/Inbox', icon: 'cart' },
    { title: 'Meus armarios', url: '/folder/Outbox', icon: 'archive' },
    { title: 'Perfil', url: '/folder/Favorites', icon: 'person' },
  ];
  public labels = ['Family', 'Friends', 'Notes', 'Work', 'Travel', 'Reminders'];
  constructor() {}
}

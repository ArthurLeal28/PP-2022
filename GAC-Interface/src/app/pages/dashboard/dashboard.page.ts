import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.page.html',
  styleUrls: ['./dashboard.page.scss'],
})
export class DashboardPage implements OnInit {
  armario1: any={
    titulo:'Armario 02',
    descricao:"Bloco B L1C2 Sem comentario"
  }
  armario2: any={
    titulo:'Armario 37',
    descricao:" Bloco B L5C3  Comentario:Embaixo da escada principal"
  }
  constructor() { }

  ngOnInit() {
  }

  public armarios = [this.armario1,this.armario2];
  public results = [...this.armarios];

  handleChange(event) {
    const query = event.target.value.toLowerCase();
    this.results = this.armarios.titulo.filter(d => d.toLowerCase().indexOf(query) > -1);
  }
}

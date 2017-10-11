import {Component, OnInit} from "@angular/core";

@Component({
  selector: 'root-component',
  template: `
    <div class="asd">Привет</div>
    <svg height="210" width="500">
      <line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(255,0,0);stroke-width:2"/>
      <asd></asd>
    </svg>
  `
})
export class RootComponent implements OnInit {
  ngOnInit(): void {
    console.log("Application initiated")
  }

  constructor() {
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Nastavnik } from '../model/nastavnik';
import { Zvanje } from '../model/zvanje';
import { NastavnikService } from '../services/nastavnik.service';
import { ZvanjeService } from '../services/zvanje.service';

@Component({
  selector: 'app-zvanje',
  templateUrl: './zvanje.component.html',
  styleUrls: ['./zvanje.component.css']
})
export class ZvanjeComponent implements OnInit {
  nastavnik: Nastavnik [] = [];
  zvanje: Zvanje [] = [];
  zvanjeUpdate: Zvanje|null = null;
  
  constructor(private zvanjeService: ZvanjeService, private nastavnikService: NastavnikService, 
    private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
  }

  getAll2() {
    this.nastavnikService.getAll().subscribe((value) => {
      this.nastavnik = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }

  getAll() {
    this.zvanjeService.getAll().subscribe((value) => {
      this.zvanje = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.zvanjeService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(zvanje: Zvanje) {
    this.zvanjeService.create(zvanje).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(zvanje: Zvanje) {
    if(this.zvanjeUpdate && this.zvanjeUpdate.id) {
      this.zvanjeService.update(this.zvanjeUpdate?.id, zvanje).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(zvanje: any) {
    this.zvanjeUpdate = { ...zvanje };
  }

  prikaziDetalje(zvanje: Zvanje) {
    this.router.navigate(["zvanja", "/", {id: zvanje.id}])
  }
}

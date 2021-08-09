import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adresa } from '../model/adresa';
import { Mesto } from '../model/mesto';
import { AdresaService } from '../services/adresa.service';
import { MestoService } from '../services/mesto.service';

@Component({
  selector: 'app-mesto',
  templateUrl: './mesto.component.html',
  styleUrls: ['./mesto.component.css']
})
export class MestoComponent implements OnInit {
  adrese: Adresa [] = []
  mesta: Mesto[] = [];
  mestoUpdate: Mesto|null = null;

  constructor(private mestoService: MestoService, private router: Router, private adresaService: AdresaService) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
    console.log(this.mesta)
  }

  getAll2() {
    this.adresaService.getAll().subscribe((value) => {
      this.adrese = value;
    }, (error) => {
      console.log(error);
    });
  }

  getAll() {
    this.mestoService.getAll().subscribe((value) => {
      this.mesta = value;
      console.log(this.mesta)
    }, (error) => {
      console.log(error);
    });
  }

  delete(id: any) {
    this.mestoService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(mesto: Mesto) {
    this.mestoService.create(mesto).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(mesto: Mesto) {
    if(this.mestoUpdate && this.mestoUpdate.id) {
      this.mestoService.update(this.mestoUpdate?.id, mesto).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(mesto: any) {
    this.mestoUpdate = { ...mesto };
  }

  prikaziDetalje(mesto: Mesto) {
    this.router.navigate(["mesta", "/", {id: mesto.id}])
  }
}

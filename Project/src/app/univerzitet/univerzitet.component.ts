import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adresa } from '../model/adresa';
import { Fakultet } from '../model/fakultet';
import { Univerzitet } from '../model/univerzitet';
import { AdresaService } from '../services/adresa.service';
import { FakultetService } from '../services/fakultet.service';
import { UniverzitetService } from '../services/univerzitet.service';

@Component({
  selector: 'app-univerzitet',
  templateUrl: './univerzitet.component.html',
  styleUrls: ['./univerzitet.component.css']
})

export class UniverzitetComponent implements OnInit {
  adrese: Adresa [] = [];
  univerziteti: Univerzitet[] = [];
  univerzitetUpdate: Univerzitet|null = null;

  constructor(private univerzitetService: UniverzitetService, private router: Router, private adresaService: AdresaService) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();

  }

  getAll2() {
    this.adresaService.getAll().subscribe((value) => {
      this.adrese = value;
    }, (error) => {
      console.log(error);
    });
  }

  getAll() {
    this.univerzitetService.getAll().subscribe((value) => {
      this.univerziteti = value;
    }, (error) => {
      console.log(error);
    });
  }

  delete(id: any) {
    this.univerzitetService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(univerzitet: Univerzitet) {
    this.univerzitetService.create(univerzitet).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(univerzitet: Univerzitet) {
    if(this.univerzitetUpdate && this.univerzitetUpdate.id) {
      this.univerzitetService.update(this.univerzitetUpdate?.id, univerzitet).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(univerzitet: any) {
    this.univerzitetUpdate = { ...univerzitet };
  }

  prikaziDetalje(univerzitet: Univerzitet) {
    this.router.navigate(["univerziteti", "/", {id: univerzitet.id}])
  }
}

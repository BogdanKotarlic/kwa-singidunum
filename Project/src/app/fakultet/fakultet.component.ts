import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fakultet } from '../model/fakultet';
import { Univerzitet } from '../model/univerzitet';
import { FakultetService } from '../services/fakultet.service';
import { UniverzitetService } from '../services/univerzitet.service';

@Component({
  selector: 'app-fakultet',
  templateUrl: './fakultet.component.html',
  styleUrls: ['./fakultet.component.css']
})
export class FakultetComponent implements OnInit {
  univerziteti: Univerzitet [] = [];
  fakulteti: Fakultet [] = [];
  fakultetUpdate: Fakultet|null = null;
  
  constructor(private fakultetService: FakultetService, private univerzitetService: UniverzitetService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
  }

  getAll2() {
    this.univerzitetService.getAll().subscribe((value) => {
      this.univerziteti = value;
    }, (error) => 
    console.log(error))
  }

  getAll() {
    this.fakultetService.getAll().subscribe((value) => {
      this.fakulteti = value; 
      debugger;
      console.log(this.fakulteti)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.fakultetService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(fakultet: Fakultet) {
    this.fakultetService.create(fakultet).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(fakultet: Fakultet) {
    if(this.fakultetUpdate && this.fakultetUpdate.id) {
      this.fakultetService.update(this.fakultetUpdate?.id, fakultet).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(fakultet: any) {
    this.fakultetUpdate = { ...fakultet };
  }

  prikaziDetalje(fakultet: Fakultet) {
    this.router.navigate(["fakulteti", "/", {id: fakultet.id}])
  }
  
}

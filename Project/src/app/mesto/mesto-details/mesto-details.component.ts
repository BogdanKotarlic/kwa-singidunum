import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MestoService } from 'src/app/services/mesto.service';

@Component({
  selector: 'app-mesto-details',
  templateUrl: './mesto-details.component.html',
  styleUrls: ['./mesto-details.component.css']
})
export class MestoDetailsComponent implements OnInit {
  mesto:any = {};

  constructor(private mestoService: MestoService, private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let mestoId = Number(this.route.snapshot.paramMap.get("id"));
    this.mesto = this.mestoService.getOne(mestoId).subscribe((value:any)=> {
      this.mesto = value;
      console.log(value)
    }, (error)=> {
      console.log(error);
      this.router.navigate(["home"]); 
    });
  }

  back() {
    this.location.back();
  }

}

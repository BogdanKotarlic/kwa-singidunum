import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PohadjanjePredmetaService } from 'src/app/services/pohadjanje-predmeta.service';

@Component({
  selector: 'app-pohadjanje-predmeta-details',
  templateUrl: './pohadjanje-predmeta-details.component.html',
  styleUrls: ['./pohadjanje-predmeta-details.component.css']
})
export class PohadjanjePredmetaDetailsComponent implements OnInit {
  pohadjanjePredmeta:any = {}

  constructor(private pohadjanjePredmetaService: PohadjanjePredmetaService ,private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let pohadjanjePredmetaId = Number(this.route.snapshot.paramMap.get("id"));
    this.pohadjanjePredmetaService.getOne(pohadjanjePredmetaId).subscribe((value:any)=> {
      this.pohadjanjePredmeta = value;
      
    }, (error)=> {
      console.log(error);
      this.router.navigate(["home"]); 
      // na klik dugmeta se pozove metoda sa ovim sadrzajem i promeni na stranicu novu
    });
  }

  back() {
    this.location.back();
  }
}

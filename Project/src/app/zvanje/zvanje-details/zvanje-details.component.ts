import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ZvanjeService } from 'src/app/services/zvanje.service';

@Component({
  selector: 'app-zvanje-details',
  templateUrl: './zvanje-details.component.html',
  styleUrls: ['./zvanje-details.component.css']
})
export class ZvanjeDetailsComponent implements OnInit {
  zvanje:any = {}

  constructor(private zvanjeService: ZvanjeService ,private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let zvanjeId = Number(this.route.snapshot.paramMap.get("id"));
    this.zvanje = this.zvanjeService.getOne(zvanjeId).subscribe((value:any)=> {
      this.zvanje = value;
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

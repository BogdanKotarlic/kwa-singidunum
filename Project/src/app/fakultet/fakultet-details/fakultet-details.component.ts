import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FakultetService } from 'src/app/services/fakultet.service';

@Component({
  selector: 'app-fakultet-details',
  templateUrl: './fakultet-details.component.html',
  styleUrls: ['./fakultet-details.component.css']
})
export class FakultetDetailsComponent implements OnInit {
  fakultet:any = {}

  constructor(private fakultetService: FakultetService ,private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let fakultetId = Number(this.route.snapshot.paramMap.get("id"));
    this.fakultetService.getOne(fakultetId).subscribe((value:any)=> {
      this.fakultet = value;
      
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

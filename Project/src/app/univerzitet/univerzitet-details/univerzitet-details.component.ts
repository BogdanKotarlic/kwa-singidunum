import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UniverzitetService } from 'src/app/services/univerzitet.service';

@Component({
  selector: 'app-univerzitet-details',
  templateUrl: './univerzitet-details.component.html',
  styleUrls: ['./univerzitet-details.component.css']
})
export class UniverzitetDetailsComponent implements OnInit {
  univerzitet:any = {};

  constructor(private univerzitetService: UniverzitetService, private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let studentId = Number(this.route.snapshot.paramMap.get("id"));
    this.univerzitet = this.univerzitetService.getOne(studentId).subscribe((value:any)=> {
      this.univerzitet = value;
    }, (error)=> {
      console.log(error);
      this.router.navigate(["home"]); 
    });
    
  }

  back() {
    this.location.back();
  }

}

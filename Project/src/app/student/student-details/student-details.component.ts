import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  student:any = {};

  constructor(private studentService: StudentService, private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let studentId = Number(this.route.snapshot.paramMap.get("id"));
    this.student = this.studentService.getOne(studentId).subscribe((value:any)=> {
      this.student = value;
    }, (error)=> {
      console.log(error);
      this.router.navigate(["home"]); 
    });
  }

  back() {
    this.location.back();
  }

}

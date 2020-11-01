import { Component, OnInit } from '@angular/core';
import { from, Subscriber } from 'rxjs';
import{Projects} from 'src/app/model/projects'
import { Router } from '@angular/router';
import{EmployeeService} from 'src/app/serviecs/employee.service'
@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
     
  project:Projects[]
  constructor(private employeService:EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(){
    this.employeService.getProjectList().subscribe(
      data=>{
        console.log("response recieved");
        this.project=data;
      },
    error=>console.log("exception occure")
    )
  }

  gotolist(){
    console.log('go back');
    this.router.navigate(['loginsuccess']);
  }
  goToViewProject(id:number){
    console.log("id"+id);
    this.router.navigate(['/projectview',id]);

  }
}

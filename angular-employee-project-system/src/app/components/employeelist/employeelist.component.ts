import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import {Employee} from 'src/app/model/employee'
import { Router } from '@angular/router';
import{EmployeeService} from 'src/app/serviecs/employee.service'

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit {

  employees:Employee[];
  searchValue:string="";


  constructor(private employeService:EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

reloadData(){
    this.employeService.getEmployeesList().subscribe(
      data=>{
        console.log("response recieved");
        this.employees=data;
      },
    error=>console.log("exception occure")
    )
  }

  gotolist(){
    console.log('go back');
    this.router.navigate(['loginsuccess']);
  }

  goToEditEmployee(id:number){
    console.log("id"+id);
    this.router.navigate(['/editEmployee',id]);
  }

  goToViewEmployee(id:number){
    console.log("id"+id);
    this.router.navigate(['/viewemployee',id]);
  }
}

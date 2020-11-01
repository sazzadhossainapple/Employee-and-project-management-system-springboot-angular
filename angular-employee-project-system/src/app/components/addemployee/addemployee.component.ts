import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import { Router } from '@angular/router';
import{EmployeeService} from 'src/app/serviecs/employee.service';
@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit {

  employees = new Employee
  constructor(private employeService:EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }
  addEmployeeformsubmit(){
    this.employeService.addEmployeeToRemote(this.employees).subscribe(
      data =>{
        console.log("data added successfuly");
        this.router.navigate(['employees']);


      },
      error =>console.log("error")

      
    )
  }
  gotolist(){
    console.log('go back');
    this.router.navigate(['loginsuccess']);
  }

 
}

import { Component, OnInit } from '@angular/core';
import{EmployeeService} from 'src/app/serviecs/employee.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/model/employee';

@Component({
  selector: 'app-editemployee',
  templateUrl: './editemployee.component.html',
  styleUrls: ['./editemployee.component.css']
})
export class EditemployeeComponent implements OnInit {
  id: number;
  employees = new Employee;

  constructor(private employeService:EmployeeService, private router: Router,
    private _activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {

    this.employees = new Employee();

    this.id = this._activatedRoute.snapshot.params['id'];
    
    this.employeService.fetchEmployeeByidFromRemote(this.id)
      .subscribe(data => {
        console.log(data)
        this.employees = data;
      }, error => console.log(error));




   
  }
  updateEmployee(){
    this.employeService.updateEmployee(this.id, this.employees)
      .subscribe(
        data =>{
          console.log(data);
          this.employees = new Employee();
          this.router.navigate(['employees']);


        } , 
        error => console.log(error));
    
  
  }

  updateEmployeeformsubmit(){
this.updateEmployee();
  }

  gotolist(){
    console.log('go back');
    this.router.navigate(['employees']);
  }
}

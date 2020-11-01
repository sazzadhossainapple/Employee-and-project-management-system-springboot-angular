import { Component, OnInit } from '@angular/core';
import{EmployeeService} from 'src/app/serviecs/employee.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/model/employee';

@Component({
  selector: 'app-deleteemployee',
  templateUrl: './deleteemployee.component.html',
  styleUrls: ['./deleteemployee.component.css']
})
export class DeleteemployeeComponent implements OnInit {
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

  gotolist(){
    console.log('go back');
    this.router.navigate(['employees']);
  }
}

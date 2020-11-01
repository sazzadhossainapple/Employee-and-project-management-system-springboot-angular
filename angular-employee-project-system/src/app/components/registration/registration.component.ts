import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { from } from 'rxjs';
import{User} from 'src/app/model/user';
import { Router } from '@angular/router';
import{EmployeeService} from 'src/app/serviecs/employee.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user = new User();
msg='';
  constructor(private employeService:EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }
  registerUser(){

    this.employeService.registerUserFromRemote(this.user).subscribe(

      data=>{
        console.log("response reciaved");
        this.router.navigate(['/singin']);
      },
      error=>{
        console.log("exception occured");

      }
    )

  }
}

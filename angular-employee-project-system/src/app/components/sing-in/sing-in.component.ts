import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { from } from 'rxjs';
import{User} from 'src/app/model/user';
import { Router } from '@angular/router';
import{EmployeeService} from 'src/app/serviecs/employee.service';
@Component({
  selector: 'app-sing-in',
  templateUrl: './sing-in.component.html',
  styleUrls: ['./sing-in.component.css']
})
export class SingInComponent implements OnInit {
user = new User();
msg='';
hide=true;
  constructor(private employeService:EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }
  loginUser(){

    this.employeService.loginUserFromRemote(this.user).subscribe(
      data=>{console.log("response recieved")
      this.router.navigate(['/loginsuccess']);
    },
      error=>{console.log("exception occured")
     this.msg='Bad credentials, please enter valid email Id and password';}
    )
  }

  gotoregistration(){
   this.router.navigate(['/registration']);
  }
}

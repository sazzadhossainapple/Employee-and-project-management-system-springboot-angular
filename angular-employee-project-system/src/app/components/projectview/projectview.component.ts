import { Component, OnInit } from '@angular/core';
import{EmployeeService} from 'src/app/serviecs/employee.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Projects } from 'src/app/model/projects';

@Component({
  selector: 'app-projectview',
  templateUrl: './projectview.component.html',
  styleUrls: ['./projectview.component.css']
})
export class ProjectviewComponent implements OnInit {
 id:number;
 project: Projects;
  constructor(private employeService:EmployeeService, private router: Router,
    private _activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {

    this.project= new Projects();

    this.id = this._activatedRoute.snapshot.params['id'];
    
    this.employeService.fetchProjectByidFromRemote(this.id)
      .subscribe(data => {
        console.log(data)
        this.project = data;
      }, error => console.log(error));
  }

  gotolist(){
    console.log('go back');
    this.router.navigate(['project']);
  }
}

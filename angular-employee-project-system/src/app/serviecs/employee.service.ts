import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { from, Observable } from 'rxjs';
import {Employee} from 'src/app/model/employee'
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }


 getEmployeesList(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/v3/employee');
  }

  addEmployeeToRemote(employees:Employee):Observable<any>{
    return this.http.post<any>("http://localhost:8080/api/v3/employee",employees);
  }

public loginUserFromRemote(user:User):Observable<any>{
   return this.http.post<any>("http://localhost:8080/api/v3/registration/login",user);
}

public registerUserFromRemote(user:User):Observable<any>{
  return this.http.post<any>("http://localhost:8080/api/v3/registration",user);
}


getProjectList(): Observable<any> {
  return this.http.get<any>('http://localhost:8080/api/v3/project');
}

fetchEmployeeByidFromRemote(id:number):Observable<any>{
  return this.http.get<any>("http://localhost:8080/api/v3/employee/"+id); 
}

updateEmployee(id: number, value: any): Observable<Object> {
  return this.http.put("http://localhost:8080/api/v3/employee/"+id, value);
}

fetchProjectByidFromRemote(id:number):Observable<any>{
  return this.http.get<any>("http://localhost:8080/api/v3/project/"+id); 
}
}

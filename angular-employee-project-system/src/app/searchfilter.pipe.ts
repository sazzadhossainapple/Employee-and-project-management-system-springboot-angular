import { Pipe, PipeTransform } from '@angular/core';
import { Employee } from './model/employee';

@Pipe({
  name: 'searchfilter'
})
export class SearchfilterPipe implements PipeTransform {

  transform(employees:Employee[], searchValue:string):Employee[] {
    
    if(!employees || !searchValue){
      return employees;
    }
    return employees.filter(employe => 
      employe.employeeName.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase()));
 
  }

}

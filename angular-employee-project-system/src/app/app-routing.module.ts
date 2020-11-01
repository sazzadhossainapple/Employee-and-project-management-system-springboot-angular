import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { from } from 'rxjs';
import { AboutComponent } from './components/about/about.component';
import { AddemployeeComponent } from './components/addemployee/addemployee.component';
import { AndroidComponent } from './components/android/android.component';
import { ContactComponent } from './components/contact/contact.component';
import { DeleteemployeeComponent } from './components/deleteemployee/deleteemployee.component';
import { EditemployeeComponent } from './components/editemployee/editemployee.component';
import { EmployeelistComponent } from './components/employeelist/employeelist.component';
import { GameComponent } from './components/game/game.component';
import { HomeComponent } from './components/home/home.component';
import { IosComponent } from './components/ios/ios.component';
import { LoginsuccessComponent } from './components/loginsuccess/loginsuccess.component';
import { ProjectComponent } from './components/project/project.component';
import { ProjectviewComponent } from './components/projectview/projectview.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { SingInComponent } from './components/sing-in/sing-in.component';
import { WebsiteComponent } from './components/website/website.component';


const routes: Routes = [
  //{path:'',component:EmployeelistComponent},
  {path:'employees',component:EmployeelistComponent},
  {path:'addemployee',component:AddemployeeComponent},
  {path:'singin',component:SingInComponent},
  {path:'loginsuccess',component:LoginsuccessComponent},
  {path:'registration',component:RegistrationComponent},
  {path:'home',component:HomeComponent},
  {path:'contact',component:ContactComponent},
  {path:'about',component:AboutComponent},
  {path:'android',component:AndroidComponent},
  {path:'web',component:WebsiteComponent},
  {path:'ios',component:IosComponent},
  {path:'game',component:GameComponent},
  {path:'project',component:ProjectComponent},
  {path:'editEmployee',component:EditemployeeComponent},
  {path:'editEmployee/:id',component:EditemployeeComponent},

  {path:'viewemployee/:id',component:DeleteemployeeComponent},
  {path:'projectview/:id',component:ProjectviewComponent}
  

  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

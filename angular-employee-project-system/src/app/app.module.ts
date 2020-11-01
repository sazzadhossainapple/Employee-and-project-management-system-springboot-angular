import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {  HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeelistComponent } from './components/employeelist/employeelist.component';
import { AddemployeeComponent } from './components/addemployee/addemployee.component';
import { EditemployeeComponent } from './components/editemployee/editemployee.component';
import { DeleteemployeeComponent } from './components/deleteemployee/deleteemployee.component';
import { FormsModule } from '@angular/forms';
import { from } from 'rxjs';
import{BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import { SingInComponent } from './components/sing-in/sing-in.component';
import { LoginsuccessComponent } from './components/loginsuccess/loginsuccess.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { SearchfilterPipe } from './searchfilter.pipe';
import{MatInputModule} from '@angular/material/input';
import { HomeComponent } from './components/home/home.component';
import { ContactComponent } from './components/contact/contact.component';
import { AboutComponent } from './components/about/about.component';
import { AndroidComponent } from './components/android/android.component';
import { WebsiteComponent } from './components/website/website.component';
import { IosComponent } from './components/ios/ios.component';
import { GameComponent } from './components/game/game.component';
import { ProjectComponent } from './components/project/project.component';
import { ProjectviewComponent } from './components/projectview/projectview.component'
@NgModule({
  declarations: [
    AppComponent,
    EmployeelistComponent,
    AddemployeeComponent,
    EditemployeeComponent,
    DeleteemployeeComponent,
    SingInComponent,
    LoginsuccessComponent,
    RegistrationComponent,
   
  
    SearchfilterPipe,
  
    HomeComponent,
  
    ContactComponent,
  
    AboutComponent,
  
    AndroidComponent,
  
    WebsiteComponent,
  
    IosComponent,
  
    GameComponent,
  
    ProjectComponent,
  
    ProjectviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BsDatepickerModule.forRoot(),
    FormsModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

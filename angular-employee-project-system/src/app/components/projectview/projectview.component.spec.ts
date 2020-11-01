import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectviewComponent } from './projectview.component';

describe('ProjectviewComponent', () => {
  let component: ProjectviewComponent;
  let fixture: ComponentFixture<ProjectviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

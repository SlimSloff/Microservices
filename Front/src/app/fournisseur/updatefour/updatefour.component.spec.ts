import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatefourComponent } from './updatefour.component';

describe('UpdatefourComponent', () => {
  let component: UpdatefourComponent;
  let fixture: ComponentFixture<UpdatefourComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatefourComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatefourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

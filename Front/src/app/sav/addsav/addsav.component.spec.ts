import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddsavComponent } from './addsav.component';

describe('AddsavComponent', () => {
  let component: AddsavComponent;
  let fixture: ComponentFixture<AddsavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddsavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddsavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

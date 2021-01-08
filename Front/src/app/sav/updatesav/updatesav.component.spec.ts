import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatesavComponent } from './updatesav.component';

describe('UpdatesavComponent', () => {
  let component: UpdatesavComponent;
  let fixture: ComponentFixture<UpdatesavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatesavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatesavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

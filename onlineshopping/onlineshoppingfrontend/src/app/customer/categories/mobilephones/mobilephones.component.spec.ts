import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MobilephonesComponent } from './mobilephones.component';

describe('MobilephonesComponent', () => {
  let component: MobilephonesComponent;
  let fixture: ComponentFixture<MobilephonesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MobilephonesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MobilephonesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
